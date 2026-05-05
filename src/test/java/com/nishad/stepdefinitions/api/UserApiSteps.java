package com.nishad.stepdefinitions.api;

import com.nishad.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UserApiSteps {
    private ConfigReader config = new ConfigReader();
    private Response response;

    @Given("the base API URL is available")
    public void the_base_api_url_is_available() {
        RestAssured.baseURI = config.getProperty("apiUrl");
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to_users(String endpoint) {
        response = given().when().get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verify_status_code(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Status code mismatch!");
    }

    @Then("the response should contain user name {string}")
    public void the_response_should_contain_user_name(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals(actualName, expectedName, "User name mismatch!");
        System.out.println("Verified User Name: " + actualName);
    }
}
