package com.nishad.stepdefinitions.api;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

/**
 * Specific step definitions for Post-related API scenarios.
 */
public class PostApiSteps {

  @Then("the response body should contain {string} with value {int}")
  public void the_response_body_should_contain_with_value(String key, int expectedValue) {
    Response response = CommonApiSteps.getResponse();
    int actualValue = response.jsonPath().getInt(key);
    Assert.assertEquals(actualValue, expectedValue, "JSON body value mismatch!");
  }
}
