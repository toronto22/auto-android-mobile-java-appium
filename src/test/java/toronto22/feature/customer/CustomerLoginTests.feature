Feature: Customer Login Tests

  Background:
    When I Navigate to Customer Login Page

  Scenario: The Login button is hidden in default
    Then I should not see the Login button

  Scenario: The Login Button Is Hidden When Deselect Your Name
    When I select Your Name "Harry Potter"
    And I select Your Name "---Your Name---"
    Then I should see the Login button

  Scenario: The Login Button Is Shown When Select Your Name
    When I select Your Name "Harry Potter"
    Then I should not see the Login button

  Scenario: Login Successfully With Valid Credential
    When I Login with your name is "Harry Potter"
    Then I should be logged in successfully