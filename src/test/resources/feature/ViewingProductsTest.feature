Feature: Viewing products Test

  Background:
    When I start and login with credential
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario: Customer view products to buy
    Then I should see the products information to buy

  Scenario Outline: Customer view products to buy by order
    When I change the order rule to view product
      | orderRule   |
      | <orderRule> |
    Then I should see the products information to buy following order
      | name                              | price |
      | Sauce Labs Bike Light             | 29.99 |
      | Sauce Labs Backpack               | 9.99  |
      | Sauce Labs Bolt T-Shirt           | 15.99 |
      | Sauce Labs Fleece Jacket          | 49.99 |
      | Sauce Labs Onesie                 | 7.99  |
      | Test.allTheThings() T-Shirt (Red) | 15.99 |
    Examples:
      | orderRule           |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  Scenario: Customer add products to cart
    When I select products to purchase
      | product                           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Then I should see list products in cart
      | product                           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario: Customer remove products from cart
    When I select products to purchase
      | product                           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I remove products from cart
      | product                 |
      | Sauce Labs Bike Light   |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    Then I should see list products in cart
      | product                           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |