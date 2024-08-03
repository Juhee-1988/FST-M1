package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void testcase1() {
		Assert.assertEquals(driver.getTitle(),"Target Practice");
		}
	
	@Test
	public void testcase2() {
		WebElement blackButton = driver.findElement(By.xpath("//button[text()='Black']"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(),"black");
		}
	
	@Test(enabled = false)
	public void testcase3() {
		String subHeading = driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subHeading.contains("Practice"));
		}
	
	@Test
	public void testcase4() {
		throw new SkipException("Skipping test case");
		}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
