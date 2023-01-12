Feature: Viewing Customer Account Tests

  Background:
    Given I logged in as a customer

  Scenario:  customerViewsAccountInformationDetails
    When I view my customer information for account "X"
    Then I should see my information details
      | customerName | accountNumber | balance | currency |
      | 1            | 1             | 1       | 1        |

  Scenario:  customerViewsAccountInformationDetails
    When I view my customer information for account "Dollar"
    Then  I should see my information details
      | customerName | accountNumber | balance | currency |
      | 1            | 1             | 1       | 1        |

