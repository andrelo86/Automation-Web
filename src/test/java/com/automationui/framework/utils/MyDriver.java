package com.automationui.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author andres.vaninetti
 *
 * This class represent a custom driver to use for our test. This driver will be instantiated just
 * one time and will be used for all test flow. All our test using the same instance of MyDriver.
 */
public final class MyDriver {

  private static final String CHROMEDRIVERPATH = "";

  private static WebDriver mdriver;

  private enum Browser {
    chrome, firefox
  }

  /**
   * Class constructor.
   */
  public MyDriver(String browser) {
    Browser navigator = Browser.valueOf(browser);
    switch (navigator) {
      case firefox:
        mdriver = new FirefoxDriver();
        break;
      case chrome:
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH);
        mdriver = new ChromeDriver();
        break;
    }
  }

  /**
   * Returns an instance of MyDriver.
   *
   * @return MyDriver
   */
  public static WebDriver getDriver() {
    return mdriver;
  }

}
