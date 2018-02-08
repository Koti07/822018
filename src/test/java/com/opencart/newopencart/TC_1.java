/*package com.opencart.newopencart;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pages.*;
import com.relevantcodes.extentreports.LogStatus;
public class TC_1 extends ExtentReportsClass {

	private static WebDriver driver = null;

@BeforeTest

public void Initialize(){
	System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
	driver = new ChromeDriver();
//	driver = new FirefoxDriver();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
public void Login(){
	
	setLogger(getExtent().startTest("Login"));
driver.get("http://10.207.182.108:81/opencart");

		// Use page Object library now
        
		HomePage.Login(driver).click();
		

		LoginPage.Email(driver).sendKeys("test4777@gmail.com");
		LoginPage.Password(driver).sendKeys("admin");
		LoginPage.Submit(driver).click();
		getLogger().log(LogStatus.PASS, "Login test case pass");

	}

@AfterTest
public void Logout(){


		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		HomePage.LogOut(driver).click(); 

		driver.quit();
	}
}
*/