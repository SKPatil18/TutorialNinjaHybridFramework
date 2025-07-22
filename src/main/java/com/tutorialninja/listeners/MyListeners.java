package com.tutorialninja.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.tutorialninja.utilities.ExtentReporter;
import com.tutorialninja.utilities.Utilities;

public class MyListeners implements ITestListener{
	ExtentReports extRep;
	 ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		try {
			extRep = ExtentReporter.generateExtentReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("Execution of project test starts");
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		 extentTest = extRep.createTest(testName);
		 extentTest.log(Status.INFO, testName +" Executed Executing");
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, testName +" Executed Successfully");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		WebDriver driver = null;
		
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String SSPath = Utilities.captureScreenshot(driver, testName);
		
		extentTest.addScreenCaptureFromPath(SSPath);
		extentTest.log(Status.FAIL, testName+" got Failed");


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName +" Test Skipped");



	}

	

	@Override
	public void onFinish(ITestContext context) {
		extRep.flush();
		String pathOfReport = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\ExtentReport.html";
		File extentReport = new File(pathOfReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

}
