Feature: Customer Logout Tests

  Background:
    Given I logged in as a customer

  Scenario:  Customer Log Out Successfully From Account Page
    When I navigate to Account Page
    When I logout of application
    Then I should see the Login page

  Scenario:  Customer Log Out Successfully From Transaction Page
    When I navigate to Customer Transaction Page
    When I logout of application
    Then I should see the Login page