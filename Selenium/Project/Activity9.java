package Activities;

import java.time.Duration;
import java.util.List;

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

public class Activity9 {
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
	public void fetchEmergencyContactsTest() {
		WebElement myInfoMenu = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		myInfoMenu.click();
		WebElement emerLink = driver.findElement(By.linkText("Emergency Contacts"));
		emerLink.click();
		List<WebElement> header = driver.findElements(By.xpath("//table[contains(@id,'emgcontact')]/thead/tr/th"));
		for(WebElement cell : header)
			System.out.println(cell.getText());
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'emgcontact')]/tbody/tr"));
		for(WebElement rowElement : rows) {
			List<WebElement> cells = rowElement.findElements(By.tagName("td"));
			for(WebElement cellElement : cells)
				System.out.println(cellElement.getText());
		}
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
