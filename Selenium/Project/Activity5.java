package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {
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
	public void editEmployeeTest() {
		WebElement myInfoMenu = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		myInfoMenu.click();
		WebElement editButton = driver.findElement(By.xpath("//input[@value='Edit']"));
		editButton.click();
		WebElement empFirstName = driver.findElement(By.xpath("//input[@title='First Name']"));
		empFirstName.clear();
		empFirstName.sendKeys("John");
		WebElement empLastName = driver.findElement(By.xpath("//input[@title='Last Name']"));
		empLastName.clear();
		empLastName.sendKeys("Doe");
		WebElement genderRadio = driver.findElement(By.id("personal_optGender_1"));
		genderRadio.click();
		WebElement nationDropdown = driver.findElement(By.id("personal_cmbNation"));
		Select select = new Select(nationDropdown);
		select.selectByIndex(82);		
		WebElement empBirthDate = driver.findElement(By.id("personal_DOB"));
		empBirthDate.clear();
		empBirthDate.sendKeys("1996-03-07");
		WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
		saveButton.click();
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
