package org.Pageobjects.Android;

import java.util.List;

import org.Utils.Android_Actions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AppiumTest.BasicClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CartPage extends Android_Actions {
	AndroidDriver driver;
	
	public static Logger logger = Logger.getLogger(BasicClass.class);


	public CartPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptButton;

	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;

	public List<WebElement> getProductList() {
		return productList;
	}

	public double getProductSum() {

		int count = productList.size();

		double totalSum = 0;

		for (int i = 0; i < count; i++) {
			String amountString = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			System.out.println("price list: " + amountString);

			double parseDouble = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum + parseDouble;

		}
		return totalSum;
	}

	public double getTotalamountdisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}

	public void accpetTermsandCondition() {

		LongPressAction(terms);
		acceptButton.click();
		logger.info("Chaveen");
	}

	public void submitOrder() throws InterruptedException {
		Thread.sleep(2000);
		checkBox.click();
		proceed.click();
	}

}
