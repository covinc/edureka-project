package com.applebite.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutTest {

	   WebDriver driver;
	   
	   @BeforeMethod
       public void beforeMethod() {
		  
		   System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.get("http://35.245.7.75:32768/");
	   }
	   
	   
	   @Test
	   public void clickAboutUs() {
		   
		   driver.findElement(By.id("About Us")).click();
		   
	   }
	   
	   @Test
	   public void verifyAboutext() {
		   String t = "This is about page";
		   List<WebElement> l= driver.findElements(By.xpath("//*[contains(text(),'This is about page')]"));
		      // verify list size
		      if ( l.size() > 0){
		         System.out.println("Text: " + t + " is present. ");
		      } else {
		         System.out.println("Text: " + t + " is not present. ");
		      }
	   }
	   
	   @AfterMethod
	   public void afterMethod() {
		   driver.close();
	   }
	   
}
