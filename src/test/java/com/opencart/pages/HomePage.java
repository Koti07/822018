package com.opencart.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver){

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}



	




	@FindBy(linkText="login")
	public  WebElement loginLink;


	@FindBy(linkText="Logout")
	public  WebElement logoutLink;


	@FindBy(linkText="create an account")
	public  WebElement createAccount;//This is Common Action
	
	@FindBy(xpath="//div[@id='slideshow0']/a")
	public  WebElement galaxyTab_adv;
	
	@FindBy(linkText="Home")
	public  WebElement homeLink;

	@FindBy(linkText="MacBook")
	public  WebElement product;
	
	@FindBy(xpath="//INPUT[@id='button-cart']")
	public  WebElement addtocart;
	
	//INPUT[@id='button-cart']
	
	@FindBy(linkText="shopping cart")
	public  WebElement shopingcart;
	
	@FindBy(id="shipping_estimate")
	public  WebElement estimateshipping;
	

	@FindBy(id="button-shipping-address")
	public  WebElement shippingcontinue;
	
	@FindBy(id="button-shipping-method")
	public  WebElement shippingmethod;
	
	@FindBy(name="shipping_method")
	public  WebElement flatshippingmethod;
	
	
	
	@FindBy(name="country_id")
	public  WebElement countrydpd;
	
	

	
	
	@FindBy(name="zone_id")
	public  WebElement zonedpd;
	
	@FindBy(name="postcode")
	public  WebElement postcode;
	
	@FindBy(id="button-quote")
	public  WebElement getquote;
	
	@FindBy(id="flat.flat")
	public  WebElement flatshipping;
	@FindBy(id="button-shipping")
	public  WebElement applyshipping;
	
	@FindBy(id="use_coupon")
	public  WebElement usecoupon;

	@FindBy(name="coupon")
	public  WebElement couponcode;
	
	
	@FindBy(xpath="(//INPUT[@type='submit'])[1]")
	public  WebElement applycoupon;
	
	
	
	
	
	
	
	
	
	@FindBy(xpath="(//INPUT[@type='text'])[2]")
	public  WebElement updatequantity;
	@FindBy(xpath="//INPUT[@type='image']")
	public  WebElement updatequantitybtn;
	@FindBy(linkText="Checkout")
	public  WebElement checkoutbtn;
	
	@FindBy(xpath="//OPTION[@value='4227'][text()='Koteswararo Majji, Wipro, HYD, Andhra Pradesh, India']")
	public  WebElement selectaddress;
	
	//*[@id="shipping-existing"]/select/option[1]
	
	@FindBy(xpath="//*[@id='shipping-existing']/select/option[3]")
	public  WebElement selectnewaddress;
	//OPTION[@value='4869'][text()='NewKoti Majji, address1, Hyderabad, Andhra Pradesh, India'][text()='NewKoti Majji, address1, Hyderabad, Andhra Pradesh, India'])[2]
	
	@FindBy(id="payment-address-new")
	public  WebElement newaddressbilling;
	
	@FindBy(id="shipping-address-new")
	public  WebElement newaddressshipping;
	
	
	
	@FindBy(id="button-payment-address")
	public  WebElement checkoutcontinuebtn;
	
	@FindBy(id="button-payment-method")
	public  WebElement paymentcontinue;
	
	@FindBy(id="cod")
	public  WebElement cashondelivery;
	
	

	@FindBy(xpath="//input[@name='agree']")
	public  WebElement termscondi;


	@FindBy(id="button-confirm")
	public  WebElement confirmbtn;
	
	@FindBy(linkText="MacBook")
	public  WebElement verifyproduct;
	
	@FindBy(linkText="Samsung Galaxy Tab 10.1")
	public  WebElement verifyproductsamsung;
	
	@FindBy(linkText="My Account")
	public  WebElement myaccounttab;
	
	@FindBy(xpath="//*[@id='footer']/div[4]/ul/li[2]/a")
	public  WebElement orderhist;
	
	@FindBy(xpath="(//IMG[@src='catalog/view/theme/default/image/info.png'])[1]")
	public  WebElement viewicon;
	
	
	@FindBy(xpath="//IMG[@src='catalog/view/theme/default/image/return.png']")
	public  WebElement returnicon;
	
	@FindBy(id="return-reason-id4")
	public  WebElement returnreason;
	
	@FindBy(xpath="(//INPUT[@type='text'])[11]")
	public  WebElement captchaoh;
	
	@FindBy(xpath="//*[@id='content']/form/div[3]/div[2]/input")
	public  WebElement ordersubmitbtn;
	
	@FindBy(xpath="//*[@id='slideshow0']/a")
	public  WebElement productbanner;
	
	@FindBy(xpath="//IMG[@id='image']")
	public  WebElement productimg;
	
	@FindBy(id="cboxNext")
	public  WebElement productimgnext;
	@FindBy(id="cboxClose")
	public  WebElement productimgclose;
	
	
	@FindBy(name="firstname")
	public  WebElement newfirstname;
	

	@FindBy(name="lastname")
	public  WebElement newlastname;
	

	@FindBy(name="address_1")
	public  WebElement newaddress1;
	

	@FindBy(name="city")
	public  WebElement newcity;
	

	@FindBy(name="country_id")
	public  WebElement newcountry;
	

	@FindBy(name="zone_id")
	public  WebElement newzone;
	
	@FindBy(id="cboxClose")
	public  WebElement closeterms;

	@FindBy(linkText="Terms & Conditions")
	public  WebElement terms;
	
	@FindBy(name="search")
	public  WebElement search;
	
	@FindBy(xpath="//DIV[@class='button-search']")
	public  WebElement searchbtn;
	
	@FindBy(linkText="Phones & PDAs")
	public  WebElement phonespads;
	
	@FindBy(xpath="//*[@id='content']/div[4]/div[1]/div[1]/div[3]/a[1]")
	public  WebElement addtocompare1;
	
	
	@FindBy(xpath="//*[@id='content']/div[4]/div[2]/div[1]/div[3]/a[1]")
	public  WebElement addtocompare2;
	
	@FindBy(xpath="//*[@id='content']/div[4]/div[3]/div[1]/div[3]/a[1]")
	public  WebElement addtocompare3;

	@FindBy(linkText="product comparison")
	public  WebElement productcomparison;
	
	@FindBy(xpath="//*[@id='content']/table/tbody[1]/tr[1]/td[3]/a[1]")
	public  WebElement firstphone;
	
	@FindBy(linkText="Newsletter")
	public  WebElement newsletter;
	
	
	@FindBy(xpath="(//INPUT[@type='radio'])[1]")
	public  WebElement newsletterradio;
	
	@FindBy(xpath="//INPUT[@type='submit']")
	public  WebElement newssubmit;
	
	
	
	
	
	
	
	


public RegistrationPage clickOnCreateLink(){
		
		createAccount.click();
		return new RegistrationPage(driver);
		
	}
	
	//Method to click on 'Samsung Galaxy Tab 10.1' advertisement
	public GalaxyProductPage clickOnGalaxyAdvTab(){
		
		
		galaxyTab_adv.click();
		return new GalaxyProductPage(driver);
	}

	



	

	

	
	
}