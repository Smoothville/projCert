package com.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;


public class NewTest3 {
	
  WebDriver driver;
   // Add options to Google Chrome. The window-size is important for responsive sites
   ChromeOptions options = new ChromeOptions();//add
  
 
  @BeforeMethod
  public void beforeMethod() {
	    options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent"); //add
	    System.setProperty("webdriver.chrome.driver", "chromedriver");
	    driver = new ChromeDriver(options);//add options
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://192.168.42.9:8081");
  }
	
  
  @Test
  public void verifyAbout() {
     String check = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	  	
    driver.findElement(By.id("About Us")).click();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      WebElement TxtBoxContent = driver.findElement(By.id("PID-ab2-pg"));
      String result = TxtBoxContent.getText();
     System.out.println("Printing: " + result);
     Assert.assertEquals(result, check);
     System.out.println("Test Successful.");

  }
  
  @AfterMethod
  public void afterMethod() {  
	  driver.close();
  }

}
