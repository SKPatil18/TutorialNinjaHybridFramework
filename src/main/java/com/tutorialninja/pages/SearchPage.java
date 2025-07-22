package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='caption']//a")
	WebElement productName;
	
	@FindBy(xpath = "//div[@id=\"content\"]/h2/following-sibling::p")
	WebElement InvalidProductMessage;
	
	
	public boolean checkProductName(String product) {
		return product.equals(productName.getText());
	}
	
	public boolean verifyInvalidProductMessage(String expectedMessage) {
		String text = InvalidProductMessage.getText();
		return expectedMessage.equals(text);
	}

}
