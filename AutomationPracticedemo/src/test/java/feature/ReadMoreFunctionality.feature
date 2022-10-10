Feature: Item read more functionality

  @ReadMore
  Scenario: Item read more functionality
    Given Open automationtesting page for item read more
    When Click on Shop Menu for item read more
    Then Click on read more button in home page
    And Read More option indicates the Out Of Stock.
    Then User cannot add the product which has read more option as it was out of stock.
