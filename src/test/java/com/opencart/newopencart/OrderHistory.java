package com.opencart.newopencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pageoperations.Homepageoperations;
import com.opencart.pageoperations.Operations;
import com.relevantcodes.extentreports.LogStatus;
import com.opencart.pages.*;

public class OrderHistory extends ExtentReportsClass {
	
	WebDriver driver;
	Operations ooperations;
	
	
	@BeforeTest

	public void Initialize(){

		System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();
		//	driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://10.207.182.108:81/opencart");
	}
@Test
	public void Orderhistory() throws InterruptedException{
		setLogger(getExtent().startTest("Orderhistory"));
		//logger = extent.createTest("Login");
		ooperations = new Operations(driver);
		
		//logger = extent.startTest("Login");

		ooperations.login();
		getLogger().log(LogStatus.INFO, "Login completed");
		ooperations.addtocart();
		getLogger().log(LogStatus.INFO, "Add to cart completed");
		try {
			ooperations.updatequantity("2");
			getLogger().log(LogStatus.INFO, "cart update completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ooperations.checkout();
		getLogger().log(LogStatus.INFO, "Checkout & Verifying order history completed");
		ooperations.ordersubmition();
		getLogger().log(LogStatus.INFO, "Order submition completed");
		ooperations.logout();
		getLogger().log(LogStatus.INFO, "Logout completed");
		getLogger().log(LogStatus.PASS, "Checking order History Pass");
		

		
	}
@AfterTest
public void closingbrowser(){
	driver.close();
	
}

}
