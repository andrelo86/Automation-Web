package com.automationapi.framework.test;

import com.automationapi.framework.ApiCatalog;
import com.automationapi.framework.BaseApiTest;
import com.automationapi.framework.entities.State;
import com.automationapi.framework.dto.StatesDto;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiTest extends BaseApiTest {

  private static final String STATES_ENDPOINT = "/states";

  @Test(testName = "checkThatAllStatesAreValidAndCorrectQuantity")
  @Parameters({"defaultStatesNumbers"})
  public void checkThatAllStatesAreValidAndCorrectQuantity(String defaultStateNumber) {
    RestAssured.baseURI = String.format(API_BASE_URL, ApiCatalog.BE_LOAN);
    RequestSpecification httpRequest = RestAssured.given();
    Response response = httpRequest.get(STATES_ENDPOINT);
    StatesDto statesDto = response.as(StatesDto.class);
    Assert.assertEquals(Integer.parseInt(defaultStateNumber), statesDto.getStates().size(),
        "The states quantity are not correct");
  }

  @Test(testName = "checkThatJustOneStateHasMinAge19AndPrintName")
  @Parameters({"minAge"})
  public void checkThatJustOneStateHasMinAge19AndPrintName(String minAge) {
    RestAssured.baseURI = String.format(API_BASE_URL, ApiCatalog.BE_LOAN);
    RequestSpecification httpRequest = RestAssured.given();
    Response response = httpRequest.get(STATES_ENDPOINT);
    StatesDto statesDto = response.as(StatesDto.class);
    List<State> collectedList = statesDto.getStates();
    List<State> filteredList = collectedList.stream().
        filter(state -> state.getMinAge()
            .equals(Integer.valueOf(minAge)))
        .collect(Collectors.toList());
    Assert.assertTrue(filteredList.size() == 1, "any or more than one country has Min Age equals to 19");
  }

  @Test(testName = "checkOnlyGeorgiaAccomplishWithMinLoanAmountValueOf")
  @Parameters({"georgiaMinAmount"})
  public void checkOnlyGeorgiaAccomplishWithMinLoanAmountValueOf(String georgiaMinAmount) {
    RestAssured.baseURI = String.format(API_BASE_URL, ApiCatalog.BE_LOAN);
    RequestSpecification httpRequest = RestAssured.given();
    Response response = httpRequest.get(STATES_ENDPOINT);
    StatesDto statesDto = response.as(StatesDto.class);
    List<State> collectedList = statesDto.getStates();
    List<State> filteredList = collectedList.stream().
        filter(state -> state.getMinLoanAmount().equals(Double.valueOf(georgiaMinAmount)))
        .collect(Collectors.toList());
    Assert.assertTrue(filteredList.size() == 1 && filteredList.get(0).getLabel().equals("Georgia"), "Georgia not accomplish with the default MinAmount");
  }

}