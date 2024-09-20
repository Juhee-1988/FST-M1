package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	//Declare driver
	AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		//Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().
				setPlatformName("android").
				setAutomationName("UiAutomator2").
				setAppPackage("com.google.android.apps.tasks").
				setAppActivity(".ui.TaskListsActivity").
				noReset();
		
		//Set the Appium Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Intializing driver
		driver = new AndroidDriver(serverURL, caps);		
	}
	
	@Test
	public void tasksAdditionTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys("Complete Activity with Google Tasks");
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys("Complete the second Activity Google Keep");
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Complete Activity with Google Tasks\"]")).isDisplayed());
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Complete Activity with Google Keep\"]")).isDisplayed());	
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Complete the second Activity Google Keep\"]")).isDisplayed());	
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
