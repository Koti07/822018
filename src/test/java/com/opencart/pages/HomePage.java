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
	
	@FindBy(xpath="(//INPUT[@type='text'])[2]")
	public  WebElement updatequantity;
	@FindBy(xpath="//INPUT[@type='image']")
	public  WebElement updatequantitybtn;
	@FindBy(linkText="Checkout")
	public  WebElement checkoutbtn;
	
	@FindBy(xpath="//OPTION[@value='4227'][text()='Koteswararo Majji, Wipro, HYD, Andhra Pradesh, India']")
	public  WebElement selectaddress;
	
	
	@FindBy(id="button-payment-address")
	public  WebElement checkoutcontinuebtn;
	
	@FindBy(id="button-payment-method")
	public  WebElement paymentcontinue;
	
	@FindBy(id="cod")
	public  WebElement cashondelivery;
	
	

	@FindBy(xpath="//input[@name='agree']")
	public  WebElement termscondi;


	@FindBy(xpath="//input[@id='button-confirm']")
	public  WebElement confirmbtn;
	
	@FindBy(linkText="MacBook")
	public  WebElement verifyproduct;
	
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
	
	@FindBy(xpath="//A[@href='index.php?route=product/product&path=57&product_id=49']")
	public  WebElement productbanner;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


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