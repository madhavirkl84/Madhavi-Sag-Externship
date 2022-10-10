#Shop Filter By Price Functionality
@tag
Feature: Price Filter

  @FilterByPrice
  Scenario: Search Item Filter By Price
    Given Open the shop testcase page
    When Click Shop Menu
    Then Adjust the filter by price between "150" to "450" rps
    And Now click on Filter button
    Then User can view books only between "150" to "450" rps price