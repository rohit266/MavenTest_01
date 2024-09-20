package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="email") WebElement username;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]") WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		System.out.println("TEsting");
	}
	
	public String validateLoginpageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
		
	}

}
