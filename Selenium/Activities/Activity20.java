package com.example.fst_m1_selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity20 {
	public static void main(String[] args) {
        // Set up Chrome driver
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find and click the button to open the alert
        driver.findElement(By.id("prompt")).click();

        // Switch focus to the alert
        Alert promptAlert = driver.switchTo().alert();

        // Print the text in the alert
        String alertText = promptAlert.getText();
        System.out.println("Text in alert: " + alertText);
        // Type into the alert
        promptAlert.sendKeys("Awesome!");

        // Close the alert by clicking OK
        promptAlert.accept();

        // Can also close the alert by clicking Cancel
        // promptAlert.dismiss();

        // Close the browser
        driver.quit();
    }

}
