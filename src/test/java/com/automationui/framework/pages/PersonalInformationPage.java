package com.automationui.framework.pages;

import com.automationui.framework.BasePage;
import com.automationui.framework.WebLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.GregorianCalendar;

public class PersonalInformationPage extends BasePage {

  // Mapping locators by name
  private static final String FIRST_NAME = "borrowerFirstName";
  private static final String LAST_NAME = "borrowerLastName";
  private static final String ZIP_CODE = "borrowerZipCode";
  private static final String DOB = "borrowerDateOfBirth";
  private static final String INDIVIDUAL_INCOME = "borrowerIncome";
  private static final String ADDITIONAL_INCOME = "borrowerAdditionalIncome";
  private static final String EMAIL = "username";
  private static final String PASSWORD = "password";

  private static final String CANDIDATE_EMAIL = "andres.vaninetti%s@upgrade-challenge.com";


  /**
   * Constructor method.
   */
  public PersonalInformationPage(WebDriver pDriver) {
    super(pDriver);
  }


  public void setRandomName() {
    getLogger(PersonalInformationPage.getClassName(this)).info("Setting name...");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, FIRST_NAME))));
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, FIRST_NAME))).click();
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, FIRST_NAME)))
        .sendKeys(generateRandomString(10, true, false));
  }

  public void setRandomLastName() {
    getLogger(PersonalInformationPage.getClassName(this)).info("Setting Lastname...");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, LAST_NAME))));
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, LAST_NAME))).click();
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, LAST_NAME)))
        .sendKeys(generateRandomString(10, true, false));
  }

  public void setRandomValidAddress() {
    getLogger(PersonalInformationPage.getClassName(this)).info("Setting Address...");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_US_ADDRESS)));
    driver.findElement(By.cssSelector(WebLocators.CSS_US_ADDRESS)).click();
    driver.findElement(By.cssSelector(WebLocators.CSS_US_ADDRESS))
        .sendKeys(generateRandomAlphaNumericString());
    wait.until(ExpectedConditions
        .elementToBeClickable(By.cssSelector(WebLocators.CSS_GEO_LIST_SUGGESTIONS)));
    driver.findElement(By.cssSelector(WebLocators.CSS_US_ADDRESS)).sendKeys(Keys.DOWN);
    driver.findElement(By.cssSelector(WebLocators.CSS_US_ADDRESS)).sendKeys(Keys.ENTER);
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, ZIP_CODE))));
    if (driver
        .findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, ZIP_CODE)))
        .getAttribute("value").isEmpty()) {
      driver.findElement(
          By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, ZIP_CODE)))
          .sendKeys(generateRandomString(6, false, true));
    }
  }

  public void setRandomValidBOD() {
    getLogger(PersonalInformationPage.getClassName(this)).info("Setting Random DOB...");
    GregorianCalendar gc = generateRandomBirthDate(1930, 2000);
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, DOB))));
    int day = gc.DAY_OF_MONTH;
    String formattedDay = String.format("%02d", day);
    int month = gc.MONTH;
    String formattedMonth = String.format("%02d", month);
    String year = Integer.toString(gc.get(gc.YEAR));
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, DOB)))
        .click();
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, DOB)))
        .sendKeys(formattedMonth + formattedDay + year);
  }

  public void setIndividualAnnualIncome(String iAnnualIncome) {
    getLogger(PersonalInformationPage.getClassName(this))
        .info("Setting Individual Annual Income...");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, INDIVIDUAL_INCOME))));
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, INDIVIDUAL_INCOME)))
        .click();
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, INDIVIDUAL_INCOME)))
        .sendKeys(iAnnualIncome);
  }

  public void setAdditionalAnnualIncome(String additionalAnnualIncome) {
    getLogger(PersonalInformationPage.getClassName(this))
        .info("Setting Additional Annual Income...");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, ADDITIONAL_INCOME))));
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, ADDITIONAL_INCOME)))
        .click();
    driver.findElement(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, ADDITIONAL_INCOME)))
        .sendKeys(additionalAnnualIncome);
  }

  public String setEmailAndReturnIt() {
    getLogger(PersonalInformationPage.getClassName(this)).info("Setting Email Annual Income...");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, EMAIL))));
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, EMAIL)))
        .click();
    String fake_mail = generateRandomString(2, false, true);
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, EMAIL)))
        .sendKeys(String.format(CANDIDATE_EMAIL, fake_mail));
    return String.format(CANDIDATE_EMAIL, fake_mail);
  }

  public void setPassword(String password) {
    getLogger(PersonalInformationPage.getClassName(this)).info("Setting Password...");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, PASSWORD))));
    driver
        .findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, PASSWORD)))
        .click();
    driver
        .findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_PERSONAL_INFO, PASSWORD)))
        .sendKeys(password);
  }

  public void markCheckboxAsRead() {
    getLogger(PersonalInformationPage.getClassName(this))
        .info("Clicking on terms and condition checkbox...");
    wait.until(
        ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_TERMS_CHECKBOX)));
    driver.findElement(By.cssSelector(WebLocators.CSS_TERMS_CHECKBOX)).click();
  }

  public OffersPage selectCheckYourRate() {
    getLogger(PersonalInformationPage.getClassName(this)).info("Clicking on check of rate...");
    wait.until(ExpectedConditions
        .elementToBeClickable(By.cssSelector(WebLocators.CSS_CHECK_YOUR_RATE_BUTTON)));
    driver.findElement(By.cssSelector(WebLocators.CSS_CHECK_YOUR_RATE_BUTTON)).click();
    return new OffersPage(driver);
  }

}
