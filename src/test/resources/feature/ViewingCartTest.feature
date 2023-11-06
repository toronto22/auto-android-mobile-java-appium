Feature: Viewing Cart Test

  Background:
    When I start and login with credential
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario: Customer view there cart after select products to purchase
    When I add products to my cart
      | product                           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I view my cart
    Then I should see my selected products
      | product                           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario: Customer remove products to buy in there cart
    When I add products to my cart
      | product                           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I view my cart
    And I remove products from my cart
      | product               |
      | Sauce Labs Bike Light |
      | Sauce Labs Backpack   |
    Then I should see my selected products
      | product                           |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario: Customer continue to buy more item
    When I add products to my cart
      | product               |
      | Sauce Labs Bike Light |
      | Sauce Labs Backpack   |
    And I view my cart
    And I choose to continue shopping
    Then I should see the Products page
