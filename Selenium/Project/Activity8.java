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

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");	
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
	public void addLeavesTest() {
		WebElement applyLeaveLink = driver.findElement(By.xpath("//span[text()='Apply Leave']"));
		applyLeaveLink.click();
		WebElement leaveType = driver.findElement(By.id("applyleave_txtLeaveType"));
		Select select = new Select(leaveType);
		select.selectByIndex(1);
		driver.findElement(By.id("applyleave_txtFromDate")).clear();
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-09-13");
		driver.findElement(By.id("applyleave_txtToDate")).clear();
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-09-13");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("view details")));
		WebElement applyButton = driver.findElement(By.id("applyBtn"));
		applyButton.click();
		WebElement myLeaveLink = driver.findElement(By.linkText("My Leave"));
		myLeaveLink.click();
		driver.findElement(By.id("calFromDate")).clear();
		driver.findElement(By.id("calFromDate")).sendKeys("2024-09-13");
		driver.findElement(By.id("calToDate")).clear();
		driver.findElement(By.id("calToDate")).sendKeys("2024-09-13");
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='btnSearch']"));
		searchButton.click();
		WebElement searchResult = driver.findElement(By.xpath("//table[contains(@id,'result')]/tbody/tr[1]/td[6]/a"));
		Assert.assertEquals(searchResult.getText(),"Pending Approval(1.00)");
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

}
