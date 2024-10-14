package AppiumTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.Pageobjects.Android.CartPage;
import org.Pageobjects.Android.FormPage;
import org.Pageobjects.Android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecomm_TC_4_Hybrid extends BasicClass {
	
	
	
	@Test(dataProvider = "getData", groups = "Regression")
	public void generalStore(HashMap<String, String> input) throws InterruptedException {

		form.setnameField(input.get("name"));
		form.setGender(input.get("gender"));
		form.countrySelection(input.get("country"));
		ProductCatalogue ProductCat = form.submitButton();

		// Add to Cart
		ProductCatalogue product = new ProductCatalogue(driver);
		product.addItemtoCartby(0);
		product.addItemtoCartby(0);
		CartPage cart = product.goToCartPage();

		double totalSum = cart.getProductSum();
		double displayFormattedSum = cart.getTotalamountdisplayed();
		// Assert.assertEquals(totalSum, displayFormattedSum);
		cart.accpetTermsandCondition();
		cart.submitOrder();
	}

	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium_FrameworkDesign\\src\\test\\java\\TestData\\Ecomm.json");
		
		// Commented this because this is how we are sending the data using the objects and parameters
//		return new Object[][] { { "Rahul shetty", "Female", "Argentina" }};

		return new Object[][] { { data.get(0)}};
		
	}
	
	
//	This is the moethod also interrelated with below methods and reason is mentioned in below method
//	@BeforeMethod
//	public void preSetup() {
//		FormPage.setData();
//	}
	
	
	/*Since Activity and Packagess is not working internally for this project
	I'm commeing this Multi Dimensonal Array to set Data for multiple exuetion
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Rahul shetty", "Female", "Argentina" }, {"Rahul", "Male", "Argentina"};
	} 
	
	*/
	
	
	/* So Conclusion for the Dataprovide topic is:
	 
	We are having multiple optios to send the data 
	1. return new Object[][] { { "Rahul shetty", "Female", "Argentina" }};
	2.return new Object[][] { { "Rahul shetty", "Female", "Argentina" }, {"Rahul", "Male", "Argentina"};
	3.List<HashMap<String, String>> data = getJsonData("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium_FrameworkDesign\\src\\test\\java\\TestData\\Ecomm.json");
      return new Object[][] { { data.get(0)}};      */

}
