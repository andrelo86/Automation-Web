package com.automationui.framework.pages;

import com.automationui.framework.BasePage;
import com.automationui.framework.WebLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author andres vaninetti
 *
 * Loan requesting page model.
 */
public class LoanRequestPage extends BasePage {

  private static final String CREDIT_CARD = "Pay off Credit Cards";


  public LoanRequestPage(WebDriver pDriver) {
    super(pDriver);
  }


  public void setLoanAmount(String loanAmount) {
    getLogger(LoanRequestPage.getClassName(this)).info("Setting loan amount: " + loanAmount);
    wait.until(
        ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_LOAN_AMOUNT)));
    driver.findElement(By.cssSelector(WebLocators.CSS_LOAN_AMOUNT)).click();
    driver.findElement(By.cssSelector(WebLocators.CSS_LOAN_AMOUNT)).sendKeys(loanAmount);
  }

  public void setLoanPurpose() {
    WebElement loanPurposeDropDown = driver
        .findElement(By.cssSelector(WebLocators.CSS_LOAN_PURPOSE));
    Select loanPurpose = new Select(loanPurposeDropDown);
    getLogger(LoanRequestPage.getClassName(this)).info("Setting loan purpose..");
    wait.until(
        ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_LOAN_PURPOSE)));
    loanPurpose.selectByVisibleText(CREDIT_CARD);
  }

  public PersonalInformationPage selectCheckYourRateButton() {
    getLogger(LoanRequestPage.getClassName(this)).info("Clicking on Check your rate button..");
    wait.until(ExpectedConditions
        .elementToBeClickable(By.cssSelector(WebLocators.CSS_CHECK_YOUR_RATE_BUTTON)));
    driver.findElement(By.cssSelector(WebLocators.CSS_CHECK_YOUR_RATE_BUTTON)).click();
    return new PersonalInformationPage(driver);
  }

}
