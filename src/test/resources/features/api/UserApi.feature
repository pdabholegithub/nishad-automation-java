@API
Feature: User API Validation

  Scenario: Verify user list API
    Given the base API URL is available
    When I send a GET request to "/users/1"
    Then the response status code should be 200
    And the response should contain user name "Leanne Graham"
