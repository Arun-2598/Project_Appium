package org.Pageobjects.Android;

import java.util.List;

import org.Utils.Android_Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends Android_Actions {
	
	AndroidDriver driver;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement Cart;
	
	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	public void addItemtoCartby(int index) throws InterruptedException {
		waits(1000);
		addToCart.get(index).click();
	}
	
	public CartPage goToCartPage() throws InterruptedException {

		Cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}

}
