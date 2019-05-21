package com.automationui.framework;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * @author andres.vaninetti
 *
 * This class contains all commons page behavior.
 */
public abstract class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;


  /**
   * Constructor method.
   */
  public BasePage(WebDriver pDriver) {
    this.driver = pDriver;
    this.wait = new WebDriverWait(pDriver, 10);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  /**
   * Return a WebDriver object with initialized elements (initElements).
   *
   * @return WebDriver : driver
   */
  public WebDriver getWebDriver() {
    return this.driver;
  }

  /**
   * This method is used to provide to logger a class name.
   *
   * @return String
   */
  public static String getClassName(Object className) {
    return className.getClass().getName();
  }

  /**
   * Return a logger with the name instance class.
   */
  public static Logger getLogger(String className) {
    return Logger.getLogger(className);
  }

  public String generateRandomString(int rdmLenght, boolean letters, boolean numbers) {
    int length = rdmLenght;
    boolean useLetters = letters;
    boolean useNumbers = numbers;
    return RandomStringUtils.random(length, useLetters, useNumbers);
  }

  public String generateRandomAlphaNumericString() {
    return RandomStringUtils.randomAlphanumeric(1);
  }

  public static int randBetween(int start, int end) {
    return start + (int) Math.round(Math.random() * (end - start));
  }

  public GregorianCalendar generateRandomBirthDate(int start, int end) {
    GregorianCalendar gc = new GregorianCalendar();
    int year = randBetween(start, end);
    gc.set(Calendar.YEAR, year);
    int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
    gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
    return gc;
  }

}
