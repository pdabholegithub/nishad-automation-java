package com.nishad.stepdefinitions.api;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

/**
 * Specific step definitions for User-related API scenarios.
 */
public class UserApiSteps {

  @Then("the response should contain user name {string}")
  public void the_response_should_contain_user_name(String expectedName) {
    Response response = CommonApiSteps.getResponse();
    String actualName = response.jsonPath().getString("name");
    Assert.assertEquals(actualName, expectedName, "User name mismatch!");
    System.out.println("Verified User Name: " + actualName);
  }
}
