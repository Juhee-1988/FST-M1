package com.example.fst_m1_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://v1.training-support.net");
		
		System.out.println("Home page title: "+ driver.getTitle());
		
		WebElement element = driver.findElement(By.id("about-link"));
		
		element.click();
		
		System.out.println("About us page title: "+ driver.getTitle());
				
		driver.quit();
		
	}

}
