Feature: Ordering Products Test

  Background:
    When I start and login with credential
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario: Ordering products successfully
    When I add products to my cart
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And I finish checkout products in my cart
      | firstName | lastName | postalCode |
      | toronto   | toronto  | 10000      |
    Then I checkout my products successfully