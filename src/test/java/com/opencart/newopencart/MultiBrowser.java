package com.opencart.newopencart;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {

	public WebDriver driver;

 

  // Passing Browser parameter from TestNG xml

  public void beforeTest(String browser) {

  // If the browser is Firefox, then do this

  if(browser.equalsIgnoreCase("firefox")) {

	  driver = new FirefoxDriver();

  // If browser is IE, then do this	  

  }else if (browser.equalsIgnoreCase("chrome")) { 

	  // Here I am setting up the path for my IEDriver

		System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();
		//	driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  } 

  // Doesn't the browser type, lauch the Website

  driver.get("http://www.store.demoqa.com"); 

  }

  // Once Before method is completed, Test method will start

  @Test public void login() throws InterruptedException {

	driver.findElement(By.xpath(".//*[@id='account']/a")).click();

    driver.findElement(By.id("log")).sendKeys("testuser_1");

    driver.findElement(By.id("pwd")).sendKeys("Test@123");

    driver.findElement(By.id("login")).click();

	}  

  @AfterClass public void afterTest() {

		driver.quit();

	}

}
