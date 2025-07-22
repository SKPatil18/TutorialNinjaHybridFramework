package com.tutorialninja.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws IOException {
		ExtentReports extentReports = new ExtentReports();
		File extentFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\ExtentReport.html");
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(extentFile);
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("TutorialNinja Test Results");
		extentSparkReporter.config().setDocumentTitle("Automation Results");
		extentSparkReporter.config().setTimeStampFormat("dd/mm//yy hh:mm:ss");
		
		extentReports.attachReporter(extentSparkReporter);
		Properties prop = new Properties();
		File infoFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\config\\config.properties");
		FileInputStream fis = new FileInputStream(infoFile);
		prop.load(fis);
		extentReports.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", prop.getProperty("browserName"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("Username", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		return extentReports;



	}
}
