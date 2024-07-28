package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {

	//Declare driver
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		//Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().
				setPlatformName("android").
				setAutomationName("UiAutomator2").
				setAppPackage("com.samsung.android.app.contacts").
				setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity").
				noReset();
		
		//Set the Appium Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Intializing driver
		driver = new AndroidDriver(serverURL, caps);	
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@Test
	public void addContact() {
		
		driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit")));
		driver.findElement(AppiumBy.accessibilityId("Show detailed name fields")).click();
		driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/firstEdit")).sendKeys("Aaditya");
		driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/lastEdit")).sendKeys("Varma");
		driver.findElement(AppiumBy.accessibilityId("Hide detailed name fields")).click();
		driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/titleText")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys("999148292");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.samsung.android.app.contacts:id/navigation_bar_item_small_label_view\" and @text=\"Save\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Edit contact")));
		String contactName = driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/header")).getText();
		Assert.assertEquals(contactName, "Aaditya Varma");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
