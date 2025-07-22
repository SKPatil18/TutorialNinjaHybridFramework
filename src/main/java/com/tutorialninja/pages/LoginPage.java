package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	WebElement emailAddressField;
	
	@FindBy(id = "input-password")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement clickOnLogin;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement emailPasswordNotMatchingWarning;
	
	
	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public AccountPage clickOnLoginButton() {
		clickOnLogin.click();
		return new AccountPage(driver);
	}
	
	public boolean getEmailPasswordNotMatchingWarning() {
		String actual = emailPasswordNotMatchingWarning.getText();
		return actual.equals("Warning: No match for E-Mail Address and/or Password.");
	}

}
