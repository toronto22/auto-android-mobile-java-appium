Feature: Adding Customer Tests

  Background:
    When I was a Manager

  Scenario:  managerAddsCustomerWithValidCustomerInformation
    When I add customer
      | firstName | lastName | postCode |
      | firstName | lastName | postCode |
    Then I should see the alert about customer is added
    And I am able to login with new customer information

  Scenario Outline:  managerIsUnableToAddCustomerWithoutMandatoryField
    When I add customer
      | firstName   | lastName   | postCode   |
      | <firstName> | <lastName> | <postCode> |
    Then I should see the add customer message
      | message                     |
      | Please fill out this field. |

    Examples:
      | firstName | lastName | postCode |
      |           | lastName | postCode |
      | firstName |          | postCode |
      | firstName | lastName |          |