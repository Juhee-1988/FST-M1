package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
		//Declare driver
		AppiumDriver driver;
		
		@BeforeClass
		public void setup() throws MalformedURLException, URISyntaxException {
			
			//Desired Capabilities
			UiAutomator2Options caps = new UiAutomator2Options().
					setPlatformName("android").
					setAutomationName("UiAutomator2").
					setAppPackage("com.sec.android.app.popupcalculator").
					setAppActivity(".Calculator").
					noReset();
			
			//Set the Appium Server URL
			URL serverURL = new URI("http://localhost:4723").toURL();
			
			//Intializing driver
			driver = new AndroidDriver(serverURL, caps);		
		}
		
		@Test
		public void multiplicationTest() {
			
			driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")).click();
			driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
			driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")).click();
			driver.findElement(AppiumBy.accessibilityId("Equal")).click();
			String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
			Assert.assertEquals(result,"54 Calculation result");
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
