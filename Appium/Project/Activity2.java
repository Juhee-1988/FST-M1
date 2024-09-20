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

public class Activity2 {
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
	public void noteAdditionTest() {
		
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test Note Title");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Test Note Description");
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		WebElement title = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"));
		WebElement desc = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description"));
		Assert.assertEquals(title.getText(), "Test Note Title");
		Assert.assertEquals(desc.getText(), "Test Note Description");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
