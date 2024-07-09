package Activities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");		
	}

	@Test
	public void titleTest() {
		String title = driver.getTitle();
		Assert.
		assertEquals(title,"OrangeHRM");
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
