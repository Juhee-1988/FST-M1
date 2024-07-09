package Activities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");		
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
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
