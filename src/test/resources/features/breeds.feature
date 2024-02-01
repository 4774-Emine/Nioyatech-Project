@breeds
Feature: Breeds

  Scenario: TC_01
    Given "breeds" path parameters are prepared for the request
    And "limit" query parameter is set 5 for request
    When GET request sent response is saved
    Then Verify response status code is 200
    Then Verify that the "origin" key value of the object at the 2 index is "Mutation"

  Scenario: TC_02
    Given "breeds" path parameters are prepared for the request
    And "limit" query parameter is set 5 for request
    When GET request sent response is saved
    Then Verify response status code is 200
    Then Verify that there are 5 objects in the returned data
