package com.nishad.tests.api;

import com.nishad.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostApiTest {
    private ConfigReader config;

    @BeforeClass
    public void setup() {
        config = new ConfigReader();
        RestAssured.baseURI = config.getProperty("apiUrl");
    }

    @Test(description = "Verify that we can retrieve a specific post by ID")
    public void verifyGetPostById() {
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        int id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");

        System.out.println("API Response Title: " + title);
        Assert.assertEquals(id, 1, "Post ID mismatch!");
        Assert.assertNotNull(title, "Title should not be null!");
    }
}
