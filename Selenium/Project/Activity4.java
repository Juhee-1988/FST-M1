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

public class Activity4 {
	
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
	public void addEmployeeTest() {
		WebElement pimMenu = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
		pimMenu.click();
		WebElement addButton = driver.findElement(By.name("btnAdd"));
		addButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Add Employee']")));
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Shoaib");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Ahmed");
		WebElement saveButton = driver.findElement(By.id("btnSave"));
		saveButton.click();
		WebElement empListMenu = driver.findElement(By.linkText("Employee List"));
		empListMenu.click();
		WebElement empName = driver.findElement(By.id("empsearch_employee_name_empName"));
		empName.sendKeys("Shoaib Ahmed");
		WebElement searchButton = driver.findElement(By.id("searchBtn"));
		searchButton.click();
		WebElement searchResult = driver.findElement(By.xpath("//table[contains(@id,'result')]/tbody/tr[1]/td[3]"));
		Assert.assertEquals(searchResult.getText(),"Shoaib");
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
