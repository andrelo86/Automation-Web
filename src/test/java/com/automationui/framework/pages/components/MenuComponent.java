package com.automationui.framework.pages.components;

import com.automationui.framework.BasePage;
import com.automationui.framework.WebLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuComponent extends BasePage {

  public MenuComponent(WebDriver pDriver) {
    super(pDriver);
  }

  public void clickOnMenuAndSelect(
      String menuItem) { // We can use another approach if we've more items.
    getLogger(MenuComponent.getClassName(this)).info("Click on menu item: " + menuItem);
    if ("logout".equals(menuItem)) {
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_MENU)));
      driver.findElement((By.cssSelector(WebLocators.CSS_MENU))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_LOGOUT)));
      driver.findElement(By.cssSelector(WebLocators.CSS_LOGOUT)).click();
    } else if ("documents".equals(menuItem)) {
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_MENU)));
      driver.findElement((By.cssSelector(WebLocators.CSS_MENU))).click();
      wait.until(
          ExpectedConditions.elementToBeClickable(By.cssSelector(WebLocators.CSS_DOCUMENTS)));
      driver.findElement(By.cssSelector(WebLocators.CSS_DOCUMENTS)).click();
    }
  }
}
