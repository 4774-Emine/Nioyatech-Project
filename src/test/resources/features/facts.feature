@facts
Feature: Facts

  Scenario: TC_01
    Given "fact" path parameters are prepared for the request
    And "max_length" query parameter is set 40 for request
    When GET request sent response is saved
    Then Verify response status code is 200
    Then Verify the returned random fact is less than 40 characters

  Scenario: TC_02
    Given "facts" path parameters are prepared for the request
    And "max_length" query parameter is set 40 for request
    And "limit" query parameter is set 5 for request
    When GET request sent response is saved
    Then Verify response status code is 200
    Then Verify that there are 5 objects in the returned data
    Then Verify that each returned fact is less than 40 characters