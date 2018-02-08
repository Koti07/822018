package com.opencart.newopencart;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pageoperations.Operations;
import com.opencart.pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
public class TC_2 extends ExtentReportsClass  {

	static WebDriver driver;
	Operations loginpageope;// = new LoginPageOperations();

	@BeforeTest

	public void Initialize(){

		System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();
		//	driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.207.182.108:81/opencart");
	}
	@Test
	public void Login(){
		setLogger(getExtent().startTest("Login"));
		//logger = extent.createTest("Login");
		loginpageope = new Operations(driver);
		//logger = extent.startTest("Login");

		loginpageope.login();

		// Use page Object library now

		getLogger().log(LogStatus.INFO, "Login test case pass");

	}
	@Test
	public void Extentreport1(){
		setLogger(getExtent().startTest("Extentreport1"));
		System.out.println("Extend reports1");
		getLogger().log(LogStatus.INFO, "Login test case pass");
	}
	@Test
	public void Extentreport5(){
		setLogger(getExtent().startTest("Extentreport1"));
		System.out.println("Extend reports1");
		getLogger().log(LogStatus.PASS, "Login test case pass");
	}

	@Test
	public void Extentreport2(){
		setLogger(getExtent().startTest("Extentreport2"));
		System.out.println("Extend reports1");
		getLogger().log(LogStatus.PASS, "Login test case pass");
	}

	@Test
	public void Extentreport3(){
		setLogger(getExtent().startTest("Extentreport3"));
		System.out.println("Extend reports1");
		getLogger().log(LogStatus.PASS, "Login test case pass");
	}

	@Test
	public void Extentreport4(){
		setLogger(getExtent().startTest("Extentreport4"));
		System.out.println("Extend reports1");
		getLogger().log(LogStatus.PASS, "Login test case pass");
	}

	@AfterTest
	public void Logout(){


		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		loginpageope.logout();

		driver.quit();
	}
}

