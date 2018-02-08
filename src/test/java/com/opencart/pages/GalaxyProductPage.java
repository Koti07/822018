package com.opencart.pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.opencart.pages.*;



public class GalaxyProductPage {
	
	WebDriver driver;
	
	@FindBy(tagName="h1")
	public WebElement heading;
	@FindBy(partialLinkText="Reviews")
	WebElement reviewTab;
	@FindBy(name="name")
	WebElement name;
	@FindBy(name="text")
	WebElement inputText;
	@FindBy(name="captcha")
	WebElement inputCaptcha;
	@FindBy(linkText="Continue")
	WebElement continueButton;
	@FindBy(xpath="//div[@class='warning']")
	public static WebElement warningToast;
	@FindBy(xpath="//div[@class='success']")
	public static WebElement successToast;
	@FindBy(linkText="Add to Wish List")
	WebElement addToWishlist;
	@FindBy(partialLinkText="Wish List")
	WebElement Wishlist;
	@FindBy(xpath="//img[@class='close']")
	WebElement close;
	
	public GalaxyProductPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public GalaxyProductPage reviewOnProduct(String reviewerName,String reviewComments,String rating){
		
		reviewTab.click();
		WebElement ratingValue = driver.findElement(By.xpath("//input[@value='"+rating+"']"));
		String a=rating;
		name.clear();
		name.sendKeys(reviewerName);
		inputText.clear();
		inputText.sendKeys(reviewComments);
		ratingValue.click();
		inputCaptcha.clear();
		
		//To Enter Captcha Manually
		System.out.println("Please enter Captcha:");
		Scanner scanner = new Scanner(System.in);
		String captcha = scanner.nextLine();		
		inputCaptcha.sendKeys(captcha);
		System.out.println("captcha entered");
		continueButton.click();
		
		System.out.println("click");
		return this;
	}
	
	public void clickOnAddToWishlist(){
		
		addToWishlist.click();
	}
	
	public String getSuccessMessage(){
		
		return successToast.getText();
	}
	
	public void closeSuccesstoast(){
		
		close.click();
		
	}
	
	public MyWishlistPage clickOnWishlist(){
		
		Wishlist.click();
		return new MyWishlistPage(driver);
	}

}