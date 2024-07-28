package liveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.attribute.DosFileAttributes;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
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
	
	@Test
	public void webAppTest() {
		
		//Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		Point start = new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.85));
		Point end = new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.65));
		
		//Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
		
		//Scroll(Fling) to the end of the page
		ActionsBase.doSwipe(driver, start, end, 50);
		
		//Wait for To-Do list link and click it
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")));
		
		driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List  Elements get added at run time\"]")).click();
		
		//Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")));
	
		//
		WebElement taskInput = driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText"));
		WebElement taskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]"));
		
		taskInput.sendKeys("Add tasks to list");
		taskButton.click();
		taskInput.sendKeys("Get number of tasks");
		taskButton.click();
		taskInput.sendKeys("Clear the list");
		taskButton.click();
		
		List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.TextView"));
		for(WebElement task:tasks) {
			task.click();			
		}
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();
			
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
