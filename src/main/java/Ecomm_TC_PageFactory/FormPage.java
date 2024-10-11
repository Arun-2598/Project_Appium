package Ecomm_TC_PageFactory;

import org.Pageobjects.Android.ProductCatalogue;
import org.Utils.Android_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends Android_Actions {
	 AndroidDriver driver;

	public FormPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement fieldName;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement selectCountry_Dropdown;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Argentina']")
	public WebElement clickCountry;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;
	
	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
	private WebElement toast;
	
		

	public void setnameField(String name) {
		fieldName.sendKeys(name);
		driver.hideKeyboard();

	}

	public void setGender(String gender) {

		if (gender.contains("Female")) {
			femaleOption.click();
		} else {
			maleOption.click();
		}
	}
	
	

	public void countrySelection(String CountryName) {
		selectCountry_Dropdown.click();
		Scroll_On_Exact_Point(CountryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + CountryName + "']")).click();

	}

	public void submitButton() {
		shopButton.click();
	}
	
	public String toastValidation() {

		return toast.getAttribute("name");
	}
	
	

}
