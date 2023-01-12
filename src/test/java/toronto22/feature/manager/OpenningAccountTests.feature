Feature: Opening Account Tests

  Background:
    When I was a Manager

  Scenario:  Manager open account for the customer
    When I open a new account for a customer
      | customerName | currency |
      | customerName | currency |
    Then I should see the open new account message
      | message |
      | success |
    Then The customer should have the new account


  Scenario Outline:  Manager open account with empty mandatory field
    When I open a new account for a customer
      | customerName   | currency   |
      | <customerName> | <currency> |
    Then I should see the open new account message
      | message                            |
      | Please select an item in the list. |
    Examples:
      | customerName | currency |
      |              | currency |
      | customerName |          |
