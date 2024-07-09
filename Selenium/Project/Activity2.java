package Activities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

	WebDriver driver;
	
	@BeforeClass
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");		
	}

	@Test
	public void headerUrlTest() {
		WebElement headerImage= driver.findElement(By.xpath("//img[contains(@src,'logo.png')]"));
		System.out.println("URL of the header image: "+ headerImage.getAttribute("src"));
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}
}
