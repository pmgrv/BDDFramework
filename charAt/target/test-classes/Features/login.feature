Feature: Login Functionality

  Scenario: Login is successfully with valid credentials
    Given User is on login page
    When User enters username and password
    And Clicks on login button
    Then user is navigated to the home page
