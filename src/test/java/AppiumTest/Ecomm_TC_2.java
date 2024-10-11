package AppiumTest;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Ecomm_TC_PageFactory.FormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class Ecomm_TC_2 extends BasicClass {
	public String products;

	private static Logger logger = Logger.getLogger(Ecomm_TC_2.class);

	// ** Due to temporary issue commented this BeforeMethod
	@BeforeMethod

	@Test(priority = 1)
	public void FillForm_ErrorValidation() throws MalformedURLException, InterruptedException {
		Thread.sleep(2000);
		FormPage forms = new FormPage(driver);
		// forms.setnameField("EPIC");
		Thread.sleep(2000);
		forms.countrySelection("Argentina");
		forms.setGender("Male");
		forms.submitButton();
		String toastValidation = forms.toastValidation();
		Assert.assertTrue(toastValidation.equals("Please enter your name"));
	}

	@BeforeMethod
	public void preSetup() {
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");		
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
		}

	@Test(priority = 1)
	public void FillForm_PositiveFlow() throws MalformedURLException, InterruptedException {

		FormPage forms = new FormPage(driver);
		forms.setnameField("EPIC");
		Thread.sleep(2000);
		forms.countrySelection("Argentina");
		forms.setGender("Male");
		forms.submitButton();
		Assert.assertTrue((driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size() < 1));

	}

}
