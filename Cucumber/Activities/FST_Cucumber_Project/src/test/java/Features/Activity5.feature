@activity5
Feature: Data driven test with Example

  Scenario Outline: Testing with Data from Scenario
    Given User is on Login page to test Muplie data
    When User enters "<Usernames>" and "<Passwords>"to test Muplie data
    Then Read the page title and confirmation message to test Muplie data
    And Close the Browser to test Muplie data

    Examples:
      | Usernames | Passwords |
      | admin     | password  |
      | adminUser | Password  |