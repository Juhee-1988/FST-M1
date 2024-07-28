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

public class Activity3 {
	
			//Declare driver
			AndroidDriver driver;
			
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
			public void additionTest() {
				
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
				driver.findElement(AppiumBy.id("calc_keypad_btn_add")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")).click();
				driver.findElement(AppiumBy.accessibilityId("Equal")).click();
				String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
				Assert.assertEquals(result,"14 Calculation result");
			}
			
			@Test
			public void subtractionTest() {
				
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
				driver.findElement(AppiumBy.accessibilityId("Minus")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
				driver.findElement(AppiumBy.accessibilityId("Equal")).click();
				String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
				Assert.assertEquals(result,"5 Calculation result");
			}
			
			@Test
			public void MultiplicationTest() {
				
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
				driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
				driver.findElement(AppiumBy.accessibilityId("Equal")).click();
				String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
				Assert.assertEquals(result,"500 Calculation result");
			}
			
			@Test
			public void DivisionTest() {
				
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")).click();
				driver.findElement(AppiumBy.accessibilityId("Division")).click();
				driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")).click();
				driver.findElement(AppiumBy.accessibilityId("Equal")).click();
				String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
				Assert.assertEquals(result,"25 Calculation result");
			}
			
			@AfterClass
			public void tearDown() {
				driver.quit();
			}

}
