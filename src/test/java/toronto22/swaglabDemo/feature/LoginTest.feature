Feature: Login Tests

  Scenario: Login Successfully With Valid Credential
    When I start and login with credential
      | username      | password     |
      | standard_user | secret_sauce |
    Then I am logged in successfully

  Scenario Outline: Login Unsuccessfully With Invalid Credential
    When I start and login with credential
      | username   | password   |
      | <username> | <password> |

    Then I should see the login error message
      | message   |
      | <message> |
    Examples:
      | username        | password     | message                                                     |
      |                 | secret_sauce | Username is required                                        |
      | standard_user   |              | Password is required                                        |
      | standard_user   |  Invalid     | Username and password do not match any user in this service.|
      | locked_out_user | secret_sauce | Sorry, this user has been locked out.                       |
