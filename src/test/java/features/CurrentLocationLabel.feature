Feature: Current Location Label Test

  As a user,
  The goal is to use current location for quick weather updates

  @normal
  Scenario: Current location label
    When the user accepts the data usage consent
    And the user clicks on the search field
    Then the Use your current location label is displayed