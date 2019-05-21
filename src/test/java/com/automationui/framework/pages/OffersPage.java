package com.automationui.framework.pages;

import com.automationui.framework.BasePage;
import com.automationui.framework.WebLocators;
import com.automationui.framework.pages.components.MenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.stream.IntStream;

public class OffersPage extends BasePage {

  private static final String MONTH_TERM = "defaultLoanTerm";
  private static final String INTEREST_RATE = "defaultLoanInterestRate";
  private static final String APR = "defaultMoreInfoAPR";
  private MenuComponent menuComponent;

  public OffersPage(WebDriver pDriver) {
    super(pDriver);
    menuComponent = new MenuComponent(pDriver);
  }

  public boolean isOfferCorrectlyStored(String loanAmount, String... offerData) {
    getLogger(OffersPage.getClassName(this)).info("Checking if data was correctly stored..");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(WebLocators.CSS_AMOUNT)));
    String dataMatcher[] = {MONTH_TERM, INTEREST_RATE, APR};
    return IntStream.range(0, offerData.length).allMatch(x -> driver
        .findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_DATA, dataMatcher[x])))
        .getText().equals(offerData[x]))
        && driver.findElement(By.cssSelector(WebLocators.CSS_AMOUNT)).getText().equals(loanAmount);
  }

  public String getLoanAmount() {
    getLogger(OffersPage.getClassName(this)).info("Picking loan amount..");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(WebLocators.CSS_AMOUNT)));
    return driver.findElement((By.cssSelector(WebLocators.CSS_AMOUNT))).getText();
  }

  public String getMonthTerm() {
    getLogger(OffersPage.getClassName(this)).info("Picking month term..");
    wait.until(ExpectedConditions.presenceOfElementLocated(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_DATA, MONTH_TERM))));
    return driver
        .findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_DATA, MONTH_TERM)))
        .getText();
  }

  public String getInterestRate() {
    getLogger(OffersPage.getClassName(this)).info("Picking Interest rate..");
    wait.until(ExpectedConditions.presenceOfElementLocated(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_DATA, INTEREST_RATE))));
    return driver
        .findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_DATA, INTEREST_RATE)))
        .getText();
  }

  public String getApr() {
    getLogger(OffersPage.getClassName(this)).info("Picking APR..");
    wait.until(ExpectedConditions.presenceOfElementLocated(
        By.cssSelector(String.format(WebLocators.CSS_GENERIC_DATA, APR))));
    return driver.findElement(By.cssSelector(String.format(WebLocators.CSS_GENERIC_DATA, APR)))
        .getText();
  }

  public MenuComponent getMenuComponent() {
    return menuComponent;
  }

}
