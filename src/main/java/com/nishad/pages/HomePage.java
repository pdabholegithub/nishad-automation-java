package com.nishad.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object class for the Nishad Institute Home Page.
 */
public class HomePage {
  private WebDriver driver;
  private WebDriverWait wait;

  // Locators
  private By exploreCoursesBtn = By.xpath("//button[contains(text(),'Explore Courses')]");
  private By contactUsLink = By.xpath("//a[contains(text(),'Contact Us')]");
  private By loginLink = By.xpath("//a[contains(text(),'Sign In')]");

  /**
   * Constructor for HomePage.
   */
  public HomePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  /**
   * Retrieves the title of the current page.
   */
  public String getTitle() {
    return driver.getTitle();
  }

  /**
   * Clicks on the Explore Courses button.
   */
  public void clickExploreCourses() {
    wait.until(ExpectedConditions.elementToBeClickable(exploreCoursesBtn)).click();
  }

  /**
   * Clicks on the Contact Us link.
   */
  public void clickContactUs() {
    wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();
  }

  /**
   * Clicks on the Sign In/Login link.
   */
  public void clickLogin() {
    wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
  }
}
