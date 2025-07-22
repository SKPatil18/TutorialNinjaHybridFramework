package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"firstname\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name=\"lastname\"]")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement email;
	
	@FindBy(xpath = "//input[@name=\"telephone\"]")
	WebElement telephone;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//input[@name=\"confirm\"]")
	WebElement confirm;
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement checkbox;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement submit;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement registerSuccessfulMessage;
	
	@FindBy(xpath = "//input[@name='newsletter']")
	WebElement subscribeRadioButton;
	
	@FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
	WebElement existingEmailWarning;
	
	public void firstNameField(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void lastNameField(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void emailField(String mail) {
		email.sendKeys(mail);
	}
	
	public void passwordField(String pass) {
		password.sendKeys(pass);
	}
	
	public void telephoneField(String tele) {
		telephone.sendKeys(tele);
	}
	
	public void confirmPasswordField(String cpass) {
		confirm.sendKeys(cpass);
	}
	
	public void checkboxField() {
		checkbox.click();
	}
	
	public void clickOnSubmitButtom() {
		submit.click();
	}
	
	public boolean registerAccountSuccessfullMessage(String expectedMessage) {
		String text = registerSuccessfulMessage.getText();
		return expectedMessage.equals(text);
		
	}
	
	public void clickOnSubscribeButton() {
		subscribeRadioButton.click();
	}
	
	public boolean existingEmailWarningMessage(String expectedMessage) {
		String text = existingEmailWarning.getText();
		return expectedMessage.equals(text);
		
	}
	
	
	
	

}
