package com.nishad.stepdefinitions.api;

import com.nishad.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PostApiSteps {
    private ConfigReader config = new ConfigReader();
    private Response response;

    @Given("the API base URI is set")
    public void the_api_base_uri_is_set() {
        RestAssured.baseURI = config.getProperty("apiUrl");
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given().when().get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("the response body should contain {string} with value {int}")
    public void the_response_body_should_contain_with_value(String key, int expectedValue) {
        int actualValue = response.jsonPath().getInt(key);
        Assert.assertEquals(actualValue, expectedValue);
    }
}
