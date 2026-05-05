package com.nishad.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties from the config.properties file.
 */
public class ConfigReader {
  private Properties properties;

  /**
   * Constructor that loads the properties from the classpath.
   */
  public ConfigReader() {
    try {
      FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
      properties = new Properties();
      properties.load(fis);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Could not find config.properties file");
    }
  }

  /**
   * Retrieves a property value based on the provided key.
   */
  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
