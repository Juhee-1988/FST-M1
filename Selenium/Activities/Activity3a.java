package com.example.fst_m1_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3a {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://v1.training-support.net/selenium/login-form");
		
		System.out.println("Login page title: "+ driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String message = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
		
		System.out.println("Login message: "+ message);
		
		driver.quit();	
		
	}

}
