package com.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatNewContactPage {
	
	@FindBy(name = "lastname")
	private WebElement lastNameTB;
	
	@FindBy(css = "input[class='crmButton small save']")
	private WebElement saveBT;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement pageHead;
	
	public CreatNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getlastNameTB() {
		return lastNameTB;
	}
	
	public WebElement getsaveBT() {
		return saveBT;
	}	
	
	public WebElement getPageHead() {
		return pageHead;
	}
}