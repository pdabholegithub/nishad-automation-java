package com.nishad.stepdefinitions.api;

import com.nishad.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

/**
 * Common step definitions for API testing.
 * Uses ThreadLocal to ensure thread-safety during parallel execution.
 */
public class CommonApiSteps {
  private static ConfigReader config = new ConfigReader();
  private static ThreadLocal<Response> response = new ThreadLocal<>();

  /**
   * Returns the thread-local instance of the Response.
   */
  public static Response getResponse() {
    return response.get();
  }

  @Given("the API base URI is set")
  public void the_api_base_uri_is_set() {
    RestAssured.baseURI = config.getProperty("apiUrl");
  }

  @Given("the base API URL is available")
  public void the_base_api_url_is_available() {
    RestAssured.baseURI = config.getProperty("apiUrl");
  }

  @When("I send a GET request to {string}")
  public void i_send_a_get_request_to(String endpoint) {
    response.set(given().when().get(endpoint));
  }

  @Then("the response status code should be {int}")
  public void the_response_status_code_should_be(int statusCode) {
    Assert.assertEquals(getResponse().getStatusCode(), statusCode, "Status code mismatch!");
  }
}
