package com.opencart.newopencart;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pageoperations.Operations;
import com.opencart.pages.HomePage;
import com.opencart.utilities.WriteData;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.opencart.pages.AccountLogoutPage;
import com.opencart.pages.GalaxyProductPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.MyWishlistPage;
import com.opencart.pages.RegistrationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.opencart.utilities.*;
import com.opencart.pageoperations.*;

public class OpencartDemo1 extends ExtentReportsClass {

	WebDriver driver = null;
	Operations ooperations;

	RegistrationPage registrationPage;
	HomePage homePage;
	GalaxyProductPage galaxyProductPage;
	MyWishlistPage myWishlistPage;
	MultiBrowser multibrowser;
	Operations loginpageope;
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

	@Test(priority='2')
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
	
	@Test(priority='3')
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
		ooperations.returnordersubmition();
		getLogger().log(LogStatus.INFO, "Order submition completed");
		ooperations.logout();
		getLogger().log(LogStatus.INFO, "Logout completed");
		getLogger().log(LogStatus.PASS, "Checking order History Pass");





	}
	
	@Test(priority='4')
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
	
	
	@Test(priority=1, dataProvider="User Details")
	public void registration(String firstname,String lastname,String emailAddress,String telephoneNum,String address1,String cityName,String postcodeNum,String country,String zone,String pwd,String confirm_pwd,String name,String reviewComments,String rating) throws Exception{
		
		homePage = new HomePage(driver);
		
		//Calling method to click on 'Create Account' link
		registrationPage = homePage.clickOnCreateLink();
		
		//Calling method to fill user details in Registration page and verify account is created
		registrationPage.fillDetailsAndRegister(firstname,lastname,emailAddress,telephoneNum,address1,cityName,postcodeNum,country,zone,pwd,confirm_pwd);
		
		Assert.assertEquals("Your Account Has Been Created!", driver.getTitle(),"Titles Not Matched: New Account Not Created");
		
		
	}
	
	//Test To add reviews on the product
	@Test(priority=2, dataProvider="ReviewInputValues")
	public void addReviewOnViewedProduct(String name,String reviewComments,String rating){
		
		//Calling method to navigate to Home Page after registration
		homePage=registrationPage.navigateToHome();//should be done from common actions class
		//Calling method to click on Galaxy tab 10.1 advertisement and verify user is redirected to respective product page
		galaxyProductPage=homePage.clickOnGalaxyAdvTab();
		Assert.assertEquals("Samsung Galaxy Tab 10.1", galaxyProductPage.heading.getText(), "User is in " +"'"+driver.getTitle()+"'"+" page");
		
		
		//Calling method to add reviews on the product
		galaxyProductPage.reviewOnProduct(name, reviewComments, rating);
		
		//Handling the error toast if displayed, when adding reviews
		try{
			if(galaxyProductPage.warningToast.getText().equalsIgnoreCase("Warning: Review Text must be between 25 and 1000 characters!")){
				
			}
		}catch(org.openqa.selenium.NoSuchElementException e){
			if(galaxyProductPage.successToast.getText().equalsIgnoreCase("Thank you for your review. It has been submitted to the webmaster for approval.")){
			
			}
		}
	
	}
	
	//Test to add product to the Wishlist
	@Test(priority=3)
	public void addToWishlist() throws Exception{
		
		
		//Calling method to click on 'Add to Wishlist' link and verify success toast is displayed
		galaxyProductPage.clickOnAddToWishlist();
		Thread.sleep(1500);
		Assert.assertTrue(galaxyProductPage.getSuccessMessage().contains("Success"), "Product is not added to Wishlist");
		
		
		//Calling method to close the success toast
		galaxyProductPage.closeSuccesstoast();
		
		//Calling method to click on 'Wishlist' link and check user is redirected to 'My Wishlist' page
		myWishlistPage = galaxyProductPage.clickOnWishlist();
		
		Assert.assertTrue(myWishlistPage.getTitle().equals("My Wish List"), "User is not redirected to wishlist page");
		
		
		
		//Verifying count in 'Wishlist' link is equal to number of products in the page
		Assert.assertEquals(myWishlistPage.valueInWishlistLink(), myWishlistPage.numOfProductsInTable(), "Value shown in wishlist link is different from number of records in the table");
		
		
		}
	
	//Test to add product to the cart
	@Test(priority=4)
	public void addToCart() throws Exception{
		
		//Calling method to get the unit prices of product and write to text file
		for(String price: myWishlistPage.storeUnitPrices()){
			
			/*WriteData is the library class created to write data to text file
			 * Created object of WriteData class and passed file name to create in specified location
			 */
			WriteData writeData = new WriteData("unitprices");
			writeData.writeTextToFile(price);
		}		
		
		//Calling method to add product to cart and verifying the success toast
		myWishlistPage.addToCart();
		Assert.assertTrue(myWishlistPage.isSuccessToastDisplayed(), "Success message is not displayed");
		
		Thread.sleep(3000);
		
		//Calling method to close the success toast
		myWishlistPage.closeSuccessToast();
		Thread.sleep(3000);
		//Verifying the success toast is closed or not
		try{
		Assert.assertTrue(myWishlistPage.isSuccessToastDisplayed());
		}catch(org.openqa.selenium.NoSuchElementException e){
			
		}
		
		//Calling method to remove product from the list and click on continue
		myWishlistPage.removeProductFromWishlistAndContinue();
		
	}

	@AfterTest
	public void closingbrowser(){
		driver.close();

	}

}
