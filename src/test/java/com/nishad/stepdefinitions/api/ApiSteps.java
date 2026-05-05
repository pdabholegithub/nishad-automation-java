package com.nishad.stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiSteps {
    private String baseUrl = "https://jsonplaceholder.typicode.com";
    private Response response;

    @Given("the base API URL is available")
    public void the_base_api_url_is_available() {
        RestAssured.baseURI = baseUrl;
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), (int) statusCode);
    }

    @Then("the response should contain user name {string}")
    public void the_response_should_contain_user_name(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals(actualName, expectedName);
    }
}
