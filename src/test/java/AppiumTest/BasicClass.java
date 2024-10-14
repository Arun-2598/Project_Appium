package AppiumTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.Pageobjects.Android.FormPage;
import org.Utils.Android_Actions;
import org.Utils.Appium_Utils;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicClass extends Appium_Utils{
	


//	public AppiumDriverLocalService server;
	public AndroidDriver driver;
	public FormPage form;

	@BeforeMethod (alwaysRun=true)
	public void ConfigureAppium() throws IOException {
		
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium_FrameworkDesign\\src\\main\\java\\org\\Resources\\data.properties");
		prop.load(fis);
		
		String IpAdress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
	//	String IP = prop.getProperty("ipAddress");
		
		
		String Port = prop.getProperty("Port");
		String Device_Name = prop.getProperty("DeviceName");
		String Set_App= prop.getProperty("App");
		
		// 1. Code to start server
		server = startAppiumServer(IpAdress,Integer.parseInt(Port));

		// 2. Setting up the Device(Simulator) Name and Apps
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(Device_Name);
		options.setApp(Set_App);

		// 3. Setting up the IP Address and Port
		driver = new AndroidDriver(server.getUrl(), options);
		form = new FormPage(driver);
		
		

	}
	
	
	
	@BeforeClass(alwaysRun=true)
	public void Property() {
		PropertyConfigurator.configure("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium\\log4j.properties");

	}
	
	
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		server.stop();
	}

}
