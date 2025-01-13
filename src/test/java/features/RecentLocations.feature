Feature: Recent Locations Test

  As a user,
  The goal is to search for cities and use the recent location feature to view the weather details for the search cities

  @normal
  Scenario Outline: Using Recent Locations to view weather details
    Given the user accepts the data usage consent
    And the user inputs "<city>" in the search field
    And the user clicks on the first search result
    And the user goes back to the main page
    Then the user should see that the main page is displayed
    When the user chooses the first city from Recent locations
    Then the user should see that the city weather page header contains "<city>"

    Examples:
      | city        |
      | London      |
      | Paris       |
      | Tokyo       |
