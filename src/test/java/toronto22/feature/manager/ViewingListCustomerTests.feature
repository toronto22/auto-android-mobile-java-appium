Feature: Viewing List Customer Tests

  Background:
    Given I was a Manager

  Scenario:  Manager view list customer table
    When I view the list customer table
    Then I should see The list customer table have "10" items

  Scenario: Manager create a new customer
    When I add customer
      | firstName | lastName | postCode |
      | firstName | lastName | postCode |
    And I open a new account for a customer
      | customerName | currency |
      | customerName | currency |
    Then I should see the customer in the customer list