package org.Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import AppiumTest.BasicClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Android_Actions{

	public AndroidDriver driver;

	public Android_Actions(AndroidDriver driver) {
		this.driver = driver;
		
	}

	public void LongPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 4000));
	}

	public void Scroll_On_Exact_Point(String TEXT) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + TEXT + "\"));"));

	}

	public void ScrollToEndAction() throws InterruptedException {
		boolean canScrollMore;

		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));
		} while (canScrollMore);
		Thread.sleep(3000);

	}

	public void SwipeAction(WebElement element, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.10));
	}

	public double getFormattedAmount(String amount) {
		return Double.parseDouble(amount.substring(1));
	}

	
	public void waits(int value) throws InterruptedException {
		Thread.sleep(value);
	}
	
	public String getScreenshotPath(String testCaseName) throws IOException {

		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = "C:\\Users\\arun.kumar\\eclipse-workspace\\Appium_FrameworkDesign\\reports" + testCaseName +".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}

}
