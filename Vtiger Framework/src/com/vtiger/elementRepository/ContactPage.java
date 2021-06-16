package com.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(css = "img[title='Create Contact...']")
	private WebElement createContactImg;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getcreateContactImg() {
		return createContactImg;
	}
}