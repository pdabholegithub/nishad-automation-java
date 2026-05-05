package com.nishad.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By exploreCoursesBtn = By.xpath("//button[contains(text(),'Explore Courses')]");
    private By contactUsLink = By.xpath("//a[contains(text(),'Contact Us')]");
    private By loginLink = By.xpath("//a[contains(text(),'Sign In')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickExploreCourses() {
        wait.until(ExpectedConditions.elementToBeClickable(exploreCoursesBtn)).click();
    }

    public void clickContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }
}
