package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPagTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	String sheetName = "contacts";
	
	public ContactsPagTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactLink();
		contactspage.showFilterButton();
	}
	
	@Test(priority=1)
	public void contactLabelTest() {
		boolean b = contactspage.verifyContactLabel();
		Assert.assertEquals(b, true, "We are not on contact page");
	}
	
//	@Test(priority=2)
//	public void selectSingleContactTest() {
//		String contacecheckbox = contactspage.selectContactByName("Lalit Verma");
//		Assert.assertEquals(contacecheckbox, "ui checked fitted read-only checkbox", "Contact Checkbox is not selected");
//	}
	
	@Test(priority=2)
	public void selectMultipleContactTest() {
		String contacecheckbox = contactspage.selectContactByName("Lalit Verma");
		Assert.assertEquals(contacecheckbox, "ui checked fitted read-only checkbox", "Contact Checkbox is not selected");
		
		String contacecheckbox01 = contactspage.selectContactByName("Sajan Dagar");
		Assert.assertEquals(contacecheckbox01, "ui checked fitted read-only checkbox", "Contact Checkbox is not selected");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String ftName, String ltName, String email) {
		//contactspage.createNewContact("Himmat", "Singh", "himmat123@yopmail.com");
		contactspage.createNewContact(ftName, ltName, email);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
