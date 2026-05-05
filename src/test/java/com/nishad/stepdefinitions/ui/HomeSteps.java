package com.nishad.stepdefinitions.ui;

import com.nishad.base.DriverManager;
import com.nishad.pages.HomePage;
import com.nishad.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {
    private HomePage homePage;
    private ConfigReader config = new ConfigReader();

    @Given("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        DriverManager.getDriver().get(config.getProperty("baseUrl"));
        homePage = new HomePage(DriverManager.getDriver());
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        String actualTitle = homePage.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), 
            "Title mismatch! Expected to contain: " + expectedTitle + " but was: " + actualTitle);
    }
}
