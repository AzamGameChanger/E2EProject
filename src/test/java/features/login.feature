Feature: Login into application

  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to the "http://www.qaclickacademy.com/" website
    And Click on Login link in home page to land on Secure sign in Page
    When User enters <username> and <password> and logs in
    Then  Verify that user is successfully logged in
    And Close browsers
    Examples:
      | username           | password |
      | test99@gmail.com   | 123456   |
      | test2020@gmail.com | 654321   |


