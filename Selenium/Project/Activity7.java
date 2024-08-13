package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {
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
	public void addQualificationTest() {
		WebElement myInfoMenu = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		myInfoMenu.click();
		WebElement qualLink = driver.findElement(By.linkText("Qualifications"));
		qualLink.click();
		WebElement addExpButton = driver.findElement(By.id("addWorkExperience"));
		addExpButton.click();
		driver.findElement(By.id("experience_employer")).sendKeys("IBM");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
		driver.findElement(By.id("experience_from_date")).clear();
		driver.findElement(By.id("experience_from_date")).sendKeys("2022-02-07");
		driver.findElement(By.id("experience_to_date")).clear();
		driver.findElement(By.id("experience_to_date")).sendKeys("2024-08-13");
		driver.findElement(By.id("experience_comments")).sendKeys("Mobile Testing");	
		WebElement saveExpButton = driver.findElement(By.xpath("//input[@value='Save']"));
		saveExpButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addWorkExperience")));		
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
