package com.opencart.pageoperations;

import org.openqa.selenium.WebDriver;

import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Homepageoperations {
	
	
	public WebDriver driver;
	LoginPage ologinpage;// = new LoginPage(driver);
	HomePage ohomepage;// = new HomePage(driver);

	// PageFactory.initElements(driver, this);
	public Homepageoperations(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
public void logout() {
		
		// TODO Auto-generated method stub
		//setLogger(getExtent().startTest("Login"));
		//driver.get("http://10.207.182.108:81/opencart");
		
		//getLogger().log(LogStatus.PASS, "Login test case pass");
	ohomepage.logoutLink.click();
		driver.quit();
		driver.close();
	}

	
	/**
	 * 
	 */
	
	

}


