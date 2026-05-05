package com.nishad.tests;

import com.nishad.base.DriverManager;
import com.nishad.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
        String browser = config.getProperty("browser");
        DriverManager.setDriver(browser);
        driver = DriverManager.getDriver();
        driver.get(config.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
