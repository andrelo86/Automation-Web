package com.automationui.framework;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.google.gson.JsonObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automationui.framework.utils.MyDriver;
import com.google.gson.JsonParser;

/**
 * @author andres.vaninetti
 *
 * This class contains all test configuration and common behavior.
 */
public abstract class BaseTest {

  private MyDriver driver;
  private JsonParser parser = new JsonParser();

  private static Logger LOGGER;

  private static final String BROWSER = "chrome";
  private static final String JSON_FILE_PATH = "src/test/java/com/automationui/framework/resources/config.json";

  /**
   * This method contains all before test actions.
   */
  @BeforeTest
  public void beforeTestActions() {
    driver = new MyDriver(BROWSER);
    MyDriver.getDriver().manage().deleteAllCookies();
    MyDriver.getDriver().manage().window().maximize();
  }

  /**
   * This method contains all after test actions.
   */
  @AfterTest
  public void afterTestActions() {
    if (this.driver != null) {
      MyDriver.getDriver().close();
    }
  }

  /**
   * Return a MyDriver object for using through the test flow.
   *
   * @return MyDriver : Object
   */
  public MyDriver getMyDriver() {
    return this.driver;
  }

  /**
   * This method focus a driver in our URL request.
   */
  public void navigateTo(String url) {
    MyDriver.getDriver().get(url);
  }

  public static String getClassName(Object className) {
    return className.getClass().getName();
  }

  public static Logger getLogger(String className) {
    LOGGER = Logger.getLogger(className);
    return LOGGER;
  }

  public String getJsonDataProperty(String property) {
    try {
      Object obj = parser.parse(new FileReader(JSON_FILE_PATH));

      JsonObject jsonObject = (JsonObject) obj;

      return jsonObject.get(property).getAsString();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return "";
  }
}