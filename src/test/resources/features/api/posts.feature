@API
Feature: Post API Operations

  Scenario: Get post details by ID
    Given the API base URI is set
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response body should contain "id" with value 1
