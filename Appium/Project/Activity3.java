package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
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
					setAppPackage("com.google.android.keep").
					setAppActivity(".activities.BrowseActivity").
					noReset();
			
			//Set the Appium Server URL
			URL serverURL = new URI("http://localhost:4723").toURL();
			
			//Intializing driver
			driver = new AndroidDriver(serverURL, caps);		
		}
		
		@Test
		public void noteWithReminderTest() {
			
			driver.findElement(AppiumBy.accessibilityId("New text note")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]")).sendKeys("Title");
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]")).sendKeys("Description");
			driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Tomorrow morning\"]")).click();
			driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
			driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/title\" and @text=\"Reminders\"]")).click();
			Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.google.android.keep:id/browse_reminder_chip\"]")).isDisplayed());
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
