@smoke

Feature:add items to wish list

  Scenario: add item to wish list

    When click on wish icon
    Then notification bar visible
    And  get number of added items
