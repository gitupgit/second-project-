@smoke
Feature: user should recover his password

  Scenario: password recovery by valid existing email adress
    Given user navigate to login page
    When  user click forget password
    And   fill Email field
    Then  user get password