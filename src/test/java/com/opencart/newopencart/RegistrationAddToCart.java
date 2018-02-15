package com.opencart.newopencart;

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

public class RegistrationAddToCart extends ExtentReportsClass {
	
	WebDriver driver = null;
	RegistrationPage registrationPage;
	HomePage homePage;
	GalaxyProductPage galaxyProductPage;
	MyWishlistPage myWishlistPage;
	MultiBrowser multibrowser;
	Operations loginpageope;
	String url;
	
	
/*	@BeforeSuite

	public void Initialize(){

		System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();
		//	driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.207.182.108:81/opencart");
	}
	*/
	
	
		@BeforeSuite

	public void Initialize(){

		System.setProperty("webdriver.chrome.driver", "D:/Softwaresdump/chromedriver.exe");
		driver = new ChromeDriver();
		//	driver = new FirefoxDriver();
		url = "http://localhost:4444/wd/hub";
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL (url), capabilities);
           
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.manage().window().maximize();
    		driver.get("http://10.207.182.108:81/opencart");
        }catch(Exception e){
            e.printStackTrace();
		
        }
	}
	//Test to create a new account for the user - [Used Apache POI to read details from Excel]
	@Test(priority=1, dataProvider="User Details")
	public void registration(String firstname,String lastname,String emailAddress,String telephoneNum,String address1,String cityName,String postcodeNum,String country,String zone,String pwd,String confirm_pwd) throws Exception{
		
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
	
	/*@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			String capturedPath = CaptureScreenshot.capture(driver, "Failed");
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(capturedPath));
		}
	}*/
	
	//Logout from the account
	/*@AfterTest
	public void Logout(){


		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		loginpageope.logout();

		driver.quit();
	}*/
	
	@AfterTest
	public void logout(){
		
		//Calling method to logout from the account and verify logout message
		AccountLogoutPage accountLogoutPage =myWishlistPage.logout();
		Assert.assertTrue(accountLogoutPage.getLogoutMessage().equals("Account Logout"), "Account Logout message is not displayed");
		//extentTest.log(LogStatus.PASS,"Account Logout message is displayed and the user is signed out from the account");
		
	}
	
	//Dataprovider - Sending inputs to add reviews to product
	@DataProvider(name = "ReviewInputValues")
	public Object[][] inputDataValues() throws Exception{
		
		ExcelData excelData = new ExcelData("D:/newopencart/TestData_Opencart.xlsx",0);
		
		int rowsCount = excelData.numOfRows();
		Object[][] data = new Object[rowsCount][3];
		for(int rows=0;rows<rowsCount;rows++){
			for(int cells =0;cells<=2;cells++){
				
				data[rows][cells] =excelData.getData(rows+1, cells);
				
			}
			
		}
		
		return data;
		
		
	}
	
	//Data provider - Sending user details for registration
	@DataProvider(name="User Details")
	public Object[][] userDetails() throws Exception{
		
		ExcelData excelData = new ExcelData("D:/newopencart/TestData_Opencart.xlsx",1);
		Object[][] data = new Object[1][11];
		for(int cells=0;cells<11;cells++){
			
			data[0][cells] = excelData.getData(1, cells);
		}
		return data;
	}

}
