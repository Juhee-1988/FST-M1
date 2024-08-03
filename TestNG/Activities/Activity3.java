package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");
	}
	
	@Test
	public void testcase1() {
		
		WebElement username = driver.findElement(By.xpath("//input[@name='Username']"));
		
		WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
		
		username.sendKeys("admin");
		
		password.sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String message = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
		
		Assert.assertEquals(message, "Welcome Back, admin");
		}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
