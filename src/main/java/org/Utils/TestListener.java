package org.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class TestListener extends Android_Actions implements ITestListener {

	public TestListener(AndroidDriver driver) {
		super(driver);
	}

	ExtentReports extents = ExtentReportNg.getReportObject();

	ExtentTest test;

	// For now I'm not able to do implement @Override Annotation in any of below
	// methods.
	// So Couldn't able to run the Extent Report now.

	public void onTestStart(ITestResult result) {

		test = extents.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass");
	}

	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable().toString());

		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extents.flush();
	}
	
	

}
