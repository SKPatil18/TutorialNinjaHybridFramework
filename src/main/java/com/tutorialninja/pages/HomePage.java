package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountDropDown;
	
	@FindBy(linkText = "Login")
	WebElement loginButton;

	@FindBy(linkText = "Register")
	WebElement registerButton;
	
	@FindBy(xpath = "//div[@id=\"search\"]/input")
	WebElement searchField;
	
	@FindBy(xpath = "//div[@id=\"search\"]//button")
	WebElement searchButton;
	
	
	
	public void clickOnMyAccount() {
		myAccountDropDown.click();
	}
	
	public LoginPage clickOnLogin() {
		loginButton.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegister() {
		registerButton.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductInSearchField(String product) {
		searchField.sendKeys(product);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}

}
