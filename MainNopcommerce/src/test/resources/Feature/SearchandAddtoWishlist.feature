Feature: Add Laptop to Wishlist

  Scenario: Search for 'Laptop' and add the first product to the wishlist
    Given I am on the homepage
    When I search for "Laptop"
    And I add the first product to the wishlist