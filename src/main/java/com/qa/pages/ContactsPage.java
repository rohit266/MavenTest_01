package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']//div//following-sibling::span") 
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[contains(text(), 'Show Filters')]")
	WebElement contactfilter;
	
//	@FindBy(xpath="//a[contains(text(),'Lalit Verma')]//parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")
//	WebElement contactcheckbox;
	
	@FindBy(xpath="//button[text()='Create']")
	WebElement createcontactbutton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		
		return contactsLabel.isDisplayed();
	}
	
	
	public void showFilterButton() {
		Actions action = new Actions(driver);
		action.moveToElement(contactfilter).build().perform();
	}
	
	
	public String selectContactByName(String name) {
		WebElement contactcheckbox = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td"+
	                                              "//preceding-sibling::td//div[@class='ui fitted read-only checkbox']"));
		System.out.println("Before Clicked====="+contactcheckbox.getAttribute("class"));
		contactcheckbox.click();
		System.out.println("After Clicked====="+contactcheckbox.getAttribute("class"));
		System.out.println("Is checkbox selected====="+contactcheckbox.isSelected());
		return contactcheckbox.getAttribute("Class");
		
	}
	
	public void createNewContact(String ftName, String ltName, String email) {
		createcontactbutton.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		emailAddress.sendKeys(email);
		saveBtn.click();
	}
	
}
