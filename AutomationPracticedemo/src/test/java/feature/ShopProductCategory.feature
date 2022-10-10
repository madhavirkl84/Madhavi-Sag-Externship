Feature: Shop product category functionality

  @ShopProduct
  Scenario: Shop product category functionality
    Given Open automationtesting page for product category
    When Click on Shop Menu for product category
    Then Click any of the product links available in the 'Android'
    Then Now user can view only that particular product 'Android'
