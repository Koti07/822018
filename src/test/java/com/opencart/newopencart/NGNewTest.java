package com.opencart.newopencart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.LogStatus;



public class NGNewTest extends ExtentReportsClass{


	@Test(priority = 1)
	public void println() {
		setLogger(getExtent().startTest("println"));
		//Assert.assertTrue(true);
		//To generate the log when the test case is passed
		System.out.println(" Hello Worl");
		getLogger().log(LogStatus.PASS, "first method is pass");



	}

	@Test(priority = 2)
	public void print() {
		setLogger(getExtent().startTest("print"));
		//Assert.assertTrue(true);
		//To generate the log when the test case is passed
		System.out.print(" Hello Worl2");
		getLogger().log(LogStatus.PASS, "second method is fail");



	}

	@Test(priority = 3)
	public void printnew() {

		setLogger(getExtent().startTest("printnew"));
		//Assert.assertTrue(true);
		//To generate the log when the test case is passed
		System.out.print(" Hello Worl3");
		getLogger().log(LogStatus.PASS, "third method is pass");



	}
	

}
