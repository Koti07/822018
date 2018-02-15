package com.opencart.newopencart;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pageoperations.Operations;
import com.relevantcodes.extentreports.LogStatus;

public class ProductComparison extends ExtentReportsClass {

	WebDriver driver = null;
	Operations ooperations;
	String url;



	/*@BeforeClass

	public void Initialize(){

		System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();
		//	driver = new FirefoxDriver();
		url = "http://localhost:4444/wd/hub";
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(url), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.manage().window().maximize();
    		driver.get("http://10.207.182.108:81/opencart");
        }catch(Exception e){
            e.printStackTrace();

        }
	}*/


	@BeforeClass

	public void Initialize(){

		System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();
		//	driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://10.207.182.108:81/opencart");
	}

	@Test()
	public void productcomparison() throws InterruptedException{
		setLogger(getExtent().startTest("productcomparison"));
		//logger = extent.createTest("Login");
		ooperations = new Operations(driver);

		//logger = extent.startTest("Login");

		ooperations.login();
		getLogger().log(LogStatus.INFO, "Login completed");

		ooperations.search();
		getLogger().log(LogStatus.INFO, "comparing the products completed");
		ooperations.addtocartfromcomp();
		getLogger().log(LogStatus.INFO, "adding the product from comparison page is completed");


		ooperations.checkoutfromcomp();

		getLogger().log(LogStatus.INFO, "Checkout is completed");
		ooperations.subscribenewsletter();
		getLogger().log(LogStatus.INFO, "subscribe to newsletter is completed");
		ooperations.logout();
		getLogger().log(LogStatus.INFO, "Logout completed");
		getLogger().log(LogStatus.PASS, "Product comparison test case is completed");
	}

	/*@AfterTest
	public void closingbrowser(){
		driver.close();

	}*/

}
