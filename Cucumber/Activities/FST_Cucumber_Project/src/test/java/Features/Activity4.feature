@activity4
Feature: Data driven test without Example

  Scenario: Testing with Data from Scenario
    Given User is navigated on Login page
    When User enters "admin" and "password"
    Then Read the page of title and confirmation message
    And Close the current Browser