package com.orangehrm.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Date;

public class ListenerUtils implements ITestListener {

	static Date date = new Date();
	static String fileName = "Results_" + date.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extentReport = ExtentReportUtils.createInstance(".\\Reports\\" + fileName);

	//Use this object to print the logs where ever we want
	public static ExtentTest extentTest;
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart Method Started...!!!");
		
		//To print logs of the Extent Report
		 extentTest = extentReport
				.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
		testReport.set(extentTest);		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Started...!!!");
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " IS PASSED" + "</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);

		if (PropertiesFileUtils.getValueForTheKey("captureScreenshot").equalsIgnoreCase("true")) {
			try {
				testReport.get().pass(markup);
				ScreenshotUtils.captureScreenshot();
				testReport.get().pass("<b>" + "<font color=" + "green>" + "Screenshot of passed" + "</font>" + "</b>",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.screenshotName).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			testReport.get().pass(markup);
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " IS FAILED" + "</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().log(Status.FAIL, markup);
		testReport.get().log(Status.FAIL, "FAILED LOG : " + result.getThrowable().getLocalizedMessage());

		try {
			ScreenshotUtils.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.screenshotName).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " IS SKIPPED" + "</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(markup);
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extentReport != null) {
			extentReport.flush();
		}
	}
}
