Feature: Customer Transactions Tests

  Background:
    Given I logged in as a customer

  Scenario: Customer deposits money with valid amount
    When I deposit money
      | amount |
      | 300    |
    Then My balance should be "111"
    And My last transaction should show correctly
      | amount | depositType |
      | 1      | a           |

  Scenario: Customer is unable to withdraw the money that exceed the balance
    When I withdraw money
      | amount |
      | 123    |
    Then I should see the withdraw message
      | message                                                                |
      | Transaction Failed. You can not withdraw amount more than the balance. |
    Then My balance should be "111"

  Scenario: Customer withdraws money with valid amount
    When I deposit Money
      | amount |
      | 123    |
    When Withdraw Money
      | amount |
      | 123    |
    Then I should see the withdraw message
      | message                |
      | Transaction successful |
    And My balance should be "111"
    And Last customer transaction is shown correctly
      | amount | depositType |
      | 1      | a           |

  Scenario: Customer resets the customer transactions
    Given I deposited money
      | amount |
      | 123    |
    And I withdrew money
      | amount |
      | 123    |
    And I reset the transactions list
    Then I should see the transactions list is empty