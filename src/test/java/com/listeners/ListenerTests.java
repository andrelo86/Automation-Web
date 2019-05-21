package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTests implements ITestListener {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_CYAN = "\u001B[36m";


  public void onTestStart(ITestResult Result) {
    System.out.println(
        ANSI_BLUE + "*****   " + "STARTING.. " + Result.getTestName() + "   *****" + ANSI_RESET);
  }

  public void onTestSuccess(ITestResult Result) {
    System.out.println(
        ANSI_GREEN + "*****   " + Result.getTestName() + " TEST SUCCESSFULLY" + "   *****"
            + ANSI_RESET);
  }

  public void onTestFailure(ITestResult Result) {
    System.out.println(
        ANSI_RED + "*****   " + Result.getTestName() + " TEST FAILED" + "   *****" + ANSI_RESET);
  }

  public void onTestSkipped(ITestResult Result) {
    System.out.println(
        ANSI_YELLOW + "*****   " + Result.getTestName() + " TEST SKIPPED" + "   *****"
            + ANSI_RESET);
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

  }

  public void onStart(ITestContext Result) {
    System.out.println(
        ANSI_CYAN + "*****   " + " STARTING SUITE " + Result.getName() + "   *****" + ANSI_RESET);
  }

  public void onFinish(ITestContext Result) {
    System.out.println(
        ANSI_CYAN + "*****   " + Result.getName() + " SUITE FINISHED" + "   *****" + ANSI_RESET);
  }

}
