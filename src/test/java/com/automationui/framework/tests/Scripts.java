package com.automationui.framework.tests;

import com.automationui.framework.BaseTest;
import com.automationui.framework.pages.OffersPage;
import com.automationui.framework.pages.PersonalInformationPage;
import com.automationui.framework.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationui.framework.pages.LoanRequestPage;
import com.automationui.framework.utils.MyDriver;

public class Scripts extends BaseTest {

  @Test(testName = "checkThatFillingFieldsWithValidDataLoansContinueWithFlow")
  @Parameters({"loanAmount", "individualAnnualIncome", "additionalAnnualIncome", "fake_password"})
  public void checkThatFillingFieldsWithValidDataLoansContinueWithFlow(String loanAmount,
      String individualAnnualIncome,
      String additionalAnnualIncome, String fake_password) {
    LoanRequestPage loanRequestPage = new LoanRequestPage(MyDriver.getDriver());
    navigateTo(getJsonDataProperty("non_dmfunnel_url"));
    loanRequestPage.setLoanAmount(loanAmount);
    loanRequestPage.setLoanPurpose();
    PersonalInformationPage personalInformationPage = loanRequestPage.selectCheckYourRateButton();
    personalInformationPage.setRandomName();
    personalInformationPage.setRandomLastName();
    personalInformationPage.setRandomValidAddress();
    personalInformationPage.setRandomValidBOD();
    personalInformationPage.setIndividualAnnualIncome(individualAnnualIncome);
    personalInformationPage.setAdditionalAnnualIncome(additionalAnnualIncome);
    String generatedRandomMail = personalInformationPage.setEmailAndReturnIt();
    personalInformationPage.setPassword(fake_password);
    personalInformationPage.markCheckboxAsRead();
    OffersPage offersPage = personalInformationPage.selectCheckYourRate();
    String pageLoanAmount = offersPage.getLoanAmount();
    String monthTerm = offersPage.getMonthTerm();
    String interestRate = offersPage.getInterestRate();
    String getApr = offersPage.getApr();
    offersPage.getMenuComponent().clickOnMenuAndSelect("logout");
    navigateTo(getJsonDataProperty("login_url"));
    SignInPage signInPage = new SignInPage(MyDriver.getDriver());
    signInPage.setUsername(generatedRandomMail);
    signInPage.setPassword(fake_password);

    Assert.assertTrue(signInPage.selectSignIn()
            .isOfferCorrectlyStored(pageLoanAmount, monthTerm, interestRate, getApr),
        "Some data wasn't stored correctly");
  }

}

