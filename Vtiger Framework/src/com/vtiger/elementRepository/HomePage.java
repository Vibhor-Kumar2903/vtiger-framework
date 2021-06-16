package com.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement logoutDropDown;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logoutLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getlogoutDropDown() {
		return logoutDropDown;
	}
	
	public WebElement getlogoutLink() {
		return logoutLink;		
	}
	
	public WebElement getContactLink() {
		return contactLink;
	}
}
