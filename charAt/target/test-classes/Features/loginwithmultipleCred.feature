Feature: Login Functionality with multiple Credentials

  Scenario Outline: Multiple users Login is successfully with valid credentials 
    Given Credentials to login
    When user enters <username> and <password> multiple times
    And Login btn Click
    Then Navigated to the home page

    Examples: 
      | username | password |
      | pk       | pk1234   |
      | man      | man1234  |
