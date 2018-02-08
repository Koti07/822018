package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



	

	final WebDriver driver;

	/*public static WebElement Email(WebDriver driver){

		element = driver.findElement(By.name("email"));
		return element;

	}

	public static WebElement Password(WebDriver driver){

		element = driver.findElement(By.name("password"));
		return element;

	}
	public static WebElement Submit(WebDriver driver){

		element = driver.findElement(By.xpath("//INPUT[@type='submit']"));
		return element;

	}*/
	public LoginPage(WebDriver driver){

        this.driver = driver;
        
      //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
	
	@FindBy(name="email")
	public  WebElement userEmail;
	
	@FindBy(name="password")
	public  WebElement userPassword;
	
	@FindBy(xpath="//INPUT[@type='submit']")
	public  WebElement submitBtn;

	

	
	
	
	
}