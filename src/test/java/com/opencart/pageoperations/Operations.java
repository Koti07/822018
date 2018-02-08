package com.opencart.pageoperations;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;


public class Operations  {

	private static final int SECONDS = 0;
	public WebDriver driver;

	LoginPage ologinpage; //= new LoginPage(driver);// = new LoginPage(driver);
	HomePage ohomepage; ///= new HomePage(driver);// = new HomePage(driver);
	
	

	// PageFactory.initElements(driver, this);
	public Operations(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}


	public void beforetest(){

	}

	public void login() {
		ologinpage = new LoginPage(driver);// = new LoginPage(driver);
		ohomepage = new HomePage(driver);//
		// TODO Auto-generated method stub
		//setLogger(getExtent().startTest("Login"));
		//driver.get("http://10.207.182.108:81/opencart");
		System.out.println("Login method invoked");


		ohomepage.loginLink.click();
		System.out.println("went to Homepage");
		ologinpage.userEmail.sendKeys("test4777@gmail.com");		
		ologinpage.userPassword.sendKeys("admin");
		ologinpage.submitBtn.click();
		//getLogger().log(LogStatus.PASS, "Login test case pass");

	}

	public void logout() {

		// TODO Auto-generated method stub
		//setLogger(getExtent().startTest("Login"));
		//driver.get("http://10.207.182.108:81/opencart");

		//getLogger().log(LogStatus.PASS, "Login test case pass");
		ohomepage.logoutLink.click();
		
	}



	public void addtocart() {
		// TODO Auto-generated method stub
		ohomepage.homeLink.click();
		ohomepage.product.click();
		ohomepage.addtocart.click();
		ohomepage.shopingcart.click();
	}
	
	
	public void addtocartfromhome() {
		// TODO Auto-generated method stub
		ohomepage.productbanner.click();
		ohomepage.addtocart.click();
		ohomepage.shopingcart.click();
	}

	public void updatequantity(String i) throws InterruptedException{

		ohomepage.updatequantity.clear();
		ohomepage.updatequantity.sendKeys(i);
		ohomepage.updatequantitybtn.click();
	}
	
	public void checkout() throws InterruptedException{
		ohomepage.checkoutbtn.click();
		Thread.sleep(4000);
		ohomepage.selectaddress.click();

		Thread.sleep(4000);

		ohomepage.checkoutcontinuebtn.click();
		Thread.sleep(4000);
		ohomepage.cashondelivery.click();
		ohomepage.termscondi.click();
		ohomepage.paymentcontinue.click();
		
if(ohomepage.verifyproduct.isDisplayed()){
			
			//ohomepage.confirmbtn.click();
			Thread.sleep(10000);
			ohomepage.confirmbtn.click();
			System.out.println("before order hist");
			ohomepage.orderhist.click();
			Thread.sleep(5000);
			System.out.println("before second click");
			ohomepage.orderhist.click();
			Thread.sleep(10000);
			System.out.println("order hist clicked");
}
	}
		
	public void ordersubmition() throws InterruptedException{
		

			
			ohomepage.viewicon.click();
			ohomepage.returnicon.click();
			ohomepage.returnreason.click();
			//ohomepage.captchaoh.sendKeys(captcha);
			System.out.println("Enter the captcha in the browser");
			Thread.sleep(12000);
			ohomepage.ordersubmitbtn.submit();

		
		
	}
		
		
		
		


	}



