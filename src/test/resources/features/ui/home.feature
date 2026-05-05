@UI
Feature: Home Page Navigation

  Scenario: Verify the home page title

    Given I navigate to the home page
    Then the page title should contain "Nishad IT Solutions"
