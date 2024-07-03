package com.example.fst_m1_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity15 {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		driver.findElement(By.cssSelector("input[class^='username-']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[starts-with(@class,'password-')]")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String message = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
		
		System.out.println("Login message: "+ message);
		
		driver.quit();	
		
	}

}
