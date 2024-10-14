package org.Utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
	static ExtentReports extents;
	public static ExtentReports getReportObject() {
		ExtentSparkReporter spark = new ExtentSparkReporter(new File("C:\\Users\\arun.kumar\\eclipse-workspace\\ExtentReport\\reports\\index.html"));
		spark.config().setReportName("Test Result");
		spark.config().setDocumentTitle("Extent Report File");
		
		extents =  new ExtentReports();
		extents.attachReporter(spark);
		extents.setSystemInfo("Tester", "Arun");
		return extents;
	}
	}


