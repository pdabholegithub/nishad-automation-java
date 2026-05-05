package com.nishad.tests.ui;

import com.nishad.pages.HomePage;
import com.nishad.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test(description = "Verify the home page title")
    public void verifyHomePageTitle() {
        HomePage homePage = new HomePage(driver);
        String title = homePage.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("Nishad IT Solutions"), "Title does not match!");
    }
}
