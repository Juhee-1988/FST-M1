package com.example.fst_m1_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://v1.training-support.net/selenium/target-practice");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
		String headertxt= driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
		
		System.out.println("Text of the 3rd header: " + headertxt);
		
		String color = driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
		
		System.out.println("Color of the 5th header: " + color);
		
		String violetButtonClass = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
		
		System.out.println("Classes of the Violet button: " + violetButtonClass);
		
		String text = driver.findElement(By.className("grey")).getText();
		
		System.out.println("Text of the Grey button: " + text);
		
		driver.quit();
	}

}
