@smoke

Feature:user should sign up


  Scenario: user can register with valid data

    Given    navigate to Register
    When  user Fill his Data
    And   click Register

    Then user should register successfully
