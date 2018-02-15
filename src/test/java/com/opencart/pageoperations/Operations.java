package com.opencart.pageoperations;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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


	public void addtocartfromhome() throws InterruptedException {
		// TODO Auto-generated method stub
		ohomepage.homeLink.click();
		ohomepage.productbanner.click();
		ohomepage.productimg.click();
		Thread.sleep(2000);

		ohomepage.productimgnext.click();
		ohomepage.productimgnext.click();
		ohomepage.productimgnext.click();
		ohomepage.productimgnext.click();
		ohomepage.productimgnext.click();
		ohomepage.productimgnext.click();
		ohomepage.productimgnext.click();
		ohomepage.productimgclose.click();
		Thread.sleep(3000);

		ohomepage.addtocart.click();
		ohomepage.shopingcart.click();
		ohomepage.estimateshipping.click();
		Select countrydpwselect = new Select(ohomepage.countrydpd);
		Select zonedpdselect = new Select (ohomepage.zonedpd);
		countrydpwselect.selectByValue("99");
		zonedpdselect.selectByValue("1476");
		ohomepage.postcode.sendKeys("12");
		ohomepage.getquote.click();
		Thread.sleep(3000);
		ohomepage.flatshipping.click();
		ohomepage.applyshipping.click();
		ohomepage.usecoupon.click();
		ohomepage.couponcode.sendKeys("455555");
		ohomepage.applycoupon.click();





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

	public void checkoutfromhome() throws InterruptedException{
		System.out.println("before checkout btn");
		ohomepage.checkoutbtn.click();

		Thread.sleep(4000);

		// Need to select new address

		ohomepage.newaddressbilling.click();
		ohomepage.newfirstname.sendKeys("NewKoti");
		ohomepage.newlastname.sendKeys("Majji");
		ohomepage.newaddress1.sendKeys("address1");
		ohomepage.newcity.sendKeys("Hyderabad");
		ohomepage.postcode.sendKeys("500082");
		Select oSelectcountry = new Select(ohomepage.newcountry);

		oSelectcountry.selectByVisibleText("India");
		Select oSelectstate = new Select(ohomepage.newzone);
		oSelectstate.selectByValue("1476");






		//ohomepage.selectaddress.click();

		Thread.sleep(4000);

		ohomepage.checkoutcontinuebtn.click();
		Thread.sleep(4000);


		ohomepage.selectnewaddress.click();
		Thread.sleep(4000);
		System.out.println("select address");





		ohomepage.shippingcontinue.click();
		System.out.println("shipping continues after ");

		//ohomepage.flatshipping.click();
		Thread.sleep(4000);
		ohomepage.shippingmethod.click();



		Thread.sleep(4000);

		//	ohomepage.checkoutcontinuebtn.click();
		Thread.sleep(4000);
		ohomepage.cashondelivery.click();
		ohomepage.terms.click();
		ohomepage.closeterms.click();
		Thread.sleep(4000);
		ohomepage.termscondi.click();
		ohomepage.paymentcontinue.click();

		if(ohomepage.verifyproductsamsung.isDisplayed()){

			//ohomepage.confirmbtn.click();
			Thread.sleep(10000);
			ohomepage.confirmbtn.click();
			System.out.println("before order hist");
			ohomepage.orderhist.click();
			Thread.sleep(5000);
			System.out.println("before second click");

			Thread.sleep(10000);
			System.out.println("order hist clicked");
		}
	}
	public void returnordersubmition() throws InterruptedException{



		ohomepage.viewicon.click();
		ohomepage.returnicon.click();
		ohomepage.returnreason.click();
		//ohomepage.captchaoh.sendKeys(captcha);
		System.out.println("Enter the captcha in the browser");
		Thread.sleep(12000);
		ohomepage.ordersubmitbtn.submit();



	}

	public void ordersubmition() throws InterruptedException{

		Thread.sleep(7000);
		ohomepage.confirmbtn.submit();

	}	
	public void search() throws InterruptedException{


		ohomepage.search.sendKeys("samsung");
		ohomepage.searchbtn.click();
		ohomepage.phonespads.click();
		Thread.sleep(5000);
		ohomepage.addtocompare1.click();
		Thread.sleep(5000);
		ohomepage.addtocompare2.click();
		System.out.println("second click done");
		Thread.sleep(5000);
		ohomepage.addtocompare3.click();
		Thread.sleep(5000);
		System.out.println("third click done");
		ohomepage.productcomparison.click();
		System.out.println("comparison click done");
		ohomepage.firstphone.click();

	}	

	public void addtocartfromcomp() {
		// TODO Auto-generated method stub

		ohomepage.addtocart.click();
		ohomepage.shopingcart.click();
	}

	public void checkoutfromcomp() throws InterruptedException{
		System.out.println("before checkout btn");
		ohomepage.checkoutbtn.click();

		Thread.sleep(4000);

		// Need to select new address

		ohomepage.newaddressbilling.click();
		ohomepage.newfirstname.sendKeys("NewKoti");
		ohomepage.newlastname.sendKeys("Majji");
		ohomepage.newaddress1.sendKeys("address1");
		ohomepage.newcity.sendKeys("Hyderabad");
		ohomepage.postcode.sendKeys("500082");
		Select oSelectcountry = new Select(ohomepage.newcountry);

		oSelectcountry.selectByVisibleText("India");
		Select oSelectstate = new Select(ohomepage.newzone);
		oSelectstate.selectByValue("1476");
		//ohomepage.selectaddress.click();

		Thread.sleep(4000);
		ohomepage.checkoutcontinuebtn.click();
		Thread.sleep(4000);
		ohomepage.selectnewaddress.click();
		Thread.sleep(4000);
		System.out.println("select address");
		ohomepage.shippingcontinue.click();
		System.out.println("shipping continues after ");

		//ohomepage.flatshipping.click();
		Thread.sleep(4000);
		ohomepage.shippingmethod.click();
		Thread.sleep(4000);

		//	ohomepage.checkoutcontinuebtn.click();
		Thread.sleep(4000);
		ohomepage.cashondelivery.click();
		ohomepage.terms.click();
		ohomepage.closeterms.click();
		Thread.sleep(4000);
		ohomepage.termscondi.click();
		ohomepage.paymentcontinue.click();
		Thread.sleep(10000);
		ohomepage.confirmbtn.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(5000);
		ohomepage.orderhist.click();
		
	}
		public void subscribenewsletter(){
			ohomepage.newsletter.click();
			if(ohomepage.newsletterradio.isSelected()){

				ohomepage.newssubmit.click();

			}else{
				ohomepage.newsletterradio.click();
				ohomepage.newssubmit.click();
		}
		
		
		
	}
}



