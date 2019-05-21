package com.automationui.framework.pages;

import com.automationui.framework.BasePage;
import com.automationui.framework.WebLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {

  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";

  public SignInPage(WebDriver pDriver) {
    super(pDriver);
  }

  public void setUsername(String username) {
    getLogger(SignInPage.getClassName(this)).info("Setting username..");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_LOGIN, USERNAME))));
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_LOGIN, USERNAME)))
        .click();
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_LOGIN, USERNAME)))
        .sendKeys(username);
  }

  public void setPassword(String password) {
    getLogger(SignInPage.getClassName(this)).info("Setting password..");
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_LOGIN, PASSWORD))));
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_LOGIN, PASSWORD)))
        .click();
    driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_LOGIN, PASSWORD)))
        .sendKeys(password);
  }

  public OffersPage selectSignIn() {
    getLogger(SignInPage.getClassName(this)).info("Clicking on sign in..");
    wait.until(
        ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_SIGN_IN_BUTTON)));
    driver.findElement(By.cssSelector(WebLocators.CSS_SIGN_IN_BUTTON)).click();
    return new OffersPage(driver);
  }


}
