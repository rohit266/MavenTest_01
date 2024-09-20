package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTest() {
		boolean b = homepage.validateHomePage();
		Assert.assertEquals(b, true,"We are not on Home Page");
	}
	
	@Test(priority=2)
	public void contactLinkTest() {
		contactpage = homepage.clickOnContactLink();
		boolean b = contactpage.verifyContactLabel();
		Assert.assertEquals(b, true,"We are not on Contact Page");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
