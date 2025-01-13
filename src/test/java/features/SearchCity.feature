Feature: Search City Test

  As a user,
  The goal is to search for cities and view weather details

  @critical
  Scenario Outline: Search for a city and view weather details
    Given the user accepts the data usage consent
    And the user inputs "<city>" in the search field
    Then the user should see that the search results list is displayed
    When the user clicks on the first search result
    Then the user should see that the city weather page header contains "<city>"

    Examples:
      | city        |
      | New York    |
      | Los Angeles |
      | Miami       |
