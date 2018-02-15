package com.opencart.newopencart;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
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

import com.opencart.pageoperations.Homepageoperations;
import com.opencart.pageoperations.Operations;
import com.relevantcodes.extentreports.LogStatus;
import com.opencart.pages.*;

public class AddingPhonestocart extends ExtentReportsClass {
	
	WebDriver driver = null;
	Operations ooperations;
	
	String url;


	@BeforeClass

	public void Initialize(){

		/*System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();*/
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
	}
	
	
/*	public static Object[][] newaddress() {
		 
        // The number of times data is repeated, test will be executed the same no. of times
 
        // Here it will execute two times
 
        return new Object[][] { { "NewKoti", "Majji","Wipro","12334","address1","Hyderabad","500080","India","Andhra Pradesh" }};
 
  }*/
	@Test()
	public void addingPhonestocart() throws InterruptedException{
		setLogger(getExtent().startTest("addingPhonestocart"));
		//logger = extent.createTest("Login");
		ooperations = new Operations(driver);

		//logger = extent.startTest("Login");

		ooperations.login();
		getLogger().log(LogStatus.INFO, "Login completed");
		
		ooperations.addtocartfromhome();
		getLogger().log(LogStatus.INFO, "Add to cart completed");
		
		ooperations.checkoutfromhome();
		
		getLogger().log(LogStatus.INFO, "checkout completed");
		
		//ooperations.ordersubmition();
		ooperations.logout();
		getLogger().log(LogStatus.INFO, "Logout completed");
		getLogger().log(LogStatus.PASS, "adding phones form home is pass");
		
		



	}
	/*@AfterTest
	public void closingbrowser(){
		driver.close();

	}*/

}


