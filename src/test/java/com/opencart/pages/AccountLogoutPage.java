package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountLogoutPage {
	
	WebDriver driver;
	
	@FindBy(tagName="h1")
	WebElement heading;
	
	public AccountLogoutPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLogoutMessage(){
		
		return heading.getText();
	}

}
