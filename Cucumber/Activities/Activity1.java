package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class Activity1 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@Given("User is on Google website")
	public void userIsOnGoogleWebsite() {
		
		driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(),"Google");
		
	}
	
	@When("User searches for Cheese")
	public void userSearchesForCheese() {
		
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Cheese",Keys.RETURN);
		
	}
	
	@Then("User should see the results")
	public void userShouldSeeTheResults() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rso")));
		WebElement results = driver.findElement(By.cssSelector("#rso"));
		Assert.assertTrue(results.isDisplayed());
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
