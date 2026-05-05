package com.nishad.hooks;

import com.nishad.base.DriverManager;
import com.nishad.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    private ConfigReader configReader;

    @Before("@UI")
    public void setupUI() {
        configReader = new ConfigReader();
        String browser = configReader.getProperty("browser");
        DriverManager.setDriver(browser);
    }

    @After("@UI")
    public void tearDownUI(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverManager.quitDriver();
    }
}
