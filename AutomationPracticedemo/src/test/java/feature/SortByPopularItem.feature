
Feature: Product Sort by Popularity

  @SortBy
  Scenario: Item sort by popularity
    Given Open automationtesting page
    When Click on Shop Menu for sorthing
    Then Click on "Sort by popularity" item in Default sorting dropdown
    Then Now user can view the popular products only
    

  