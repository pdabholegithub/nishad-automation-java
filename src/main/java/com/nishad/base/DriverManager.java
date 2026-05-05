package com.nishad.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Manages the WebDriver instance using ThreadLocal for parallel execution.
 */
public class DriverManager {
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  /**
   * Returns the current instance of WebDriver.
   */
  public static WebDriver getDriver() {
    return driver.get();
  }

  /**
   * Initializes the WebDriver based on the browser type and headless configuration.
   */
  public static void setDriver(String browser) {
    WebDriver dr;
    switch (browser.toLowerCase()) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (System.getProperty("headless") != null 
            && System.getProperty("headless").equals("true")) {
          options.addArguments("--headless");
          options.addArguments("--disable-gpu");
          options.addArguments("--window-size=1920,1080");
        }
        dr = new ChromeDriver(options);
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        dr = new FirefoxDriver();
        break;
      case "edge":
        WebDriverManager.edgedriver().setup();
        dr = new EdgeDriver();
        break;
      default:
        throw new RuntimeException("Unsupported browser: " + browser);
    }
    dr.manage().window().maximize();
    dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.set(dr);
  }

  /**
   * Quits the driver and removes it from the ThreadLocal reference.
   */
  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
