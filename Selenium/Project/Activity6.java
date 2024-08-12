package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void loginTest() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		WebElement login = driver.findElement(By.name("Submit"));
		login.click();
		WebElement header = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
		Assert.assertEquals(header.getText(),"Dashboard");
	}
	
	@Test (dependsOnMethods={"loginTest"})
	public void verifyElementsTest() {
		WebElement directoryMenu = driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
		Assert.assertTrue(directoryMenu.isDisplayed());
		Assert.assertTrue(directoryMenu.isEnabled());
		if(directoryMenu.isDisplayed() & directoryMenu.isEnabled())
		directoryMenu.click();
		WebElement header = driver.findElement(By.xpath("//h1[text()='Search Directory']"));
		Assert.assertEquals(header.getText(),"Search Directory");	
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
