@smoke
Feature: user can search

  Scenario: user can search by name
    Given write search keyword as "<keyword>"
    When  click on search btn
    Then  search result displayed


    Examples:outline1
      |keyword|
      |nike   |
      |book   |


  Scenario: user can search by sku
    Given write search keyword as "<SKU>"
    When  click on search btn
    Then  sku search result displayed

    Examples:outline2Feature: user can search

      |SKU|
    |APPLE_CAM|
    |FL_GIRL_B|
