@smoke
Feature: user should go login page
  Background: loginPage
   Given navigate to login page


Scenario: user login with valid data
When      user enter "automation@gmail.com" and "123456"
And       click on login btn
Then user could login successfully


  Scenario: user login with invalid data
    When    user enter "test@gmail.com" and "automationtest"
    And     click on login btn
    Then    user could not login successfully



