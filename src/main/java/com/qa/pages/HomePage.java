package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//b[text()='Chetu India pvt. Ltd.']") WebElement companyname;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]") WebElement contactlinks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateHomePage() {
		return companyname.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactlinks).build().perform();
		contactlinks.click();
		return new ContactsPage();
		
	}
}
