package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options caps = new UiAutomator2Options().
				setPlatformName("android").
				setAutomationName("UiAutomator2").
				setAppPackage("com.android.chrome").
				setAppActivity("com.google.android.apps.chrome.Main").
				noReset();
		
		//Set the Appium Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Intializing driver
		driver = new AndroidDriver(serverURL, caps);	
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Open Selenium page
		driver.get("https://v1.training-support.net/selenium");
	}
	
	@Test(priority=1)
	public void validLoginTest() {
		
		//Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		Point start = new Point((int)(dims.getWidth()*0.45),(int)(dims.getHeight()*0.69));
		Point end = new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.20));
		
		//Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
		
		//Scroll(Fling) to the end of the page
		ActionsBase.doSwipe(driver, start, end, 200);
		
		//Wait for To-Do list link and click it
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text=\"Login Form Please sign in.\"]")));
		
		driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Login Form Please sign in.\"]")).click();
		
		//Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@resource-id=\"dynamic-attributes-form\"]/android.view.View")));
	
		WebElement username = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
		WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
		WebElement message = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]"));
		Assert.assertEquals(message.getText(), "Welcome Back, admin");			
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		
		//Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		Point start = new Point((int)(dims.getWidth()*0.45),(int)(dims.getHeight()*0.69));
		Point end = new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.20));
		
		//Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
		
		//Scroll(Fling) to the end of the page
		ActionsBase.doSwipe(driver, start, end, 200);
		
		//Wait for To-Do list link and click it
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text=\"Login Form Please sign in.\"]")));
		
		driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Login Form Please sign in.\"]")).click();
		
		//Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@resource-id=\"dynamic-attributes-form\"]/android.view.View")));
	
		WebElement username = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]"));
		WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]"));
		
		username.sendKeys("administrator");
		password.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
		WebElement message = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]"));
		Assert.assertEquals(message.getText(), "Invalid Credentials");			
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
