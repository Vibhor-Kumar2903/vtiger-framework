package com.vtiger.genericLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	public void acceptAlert() {
		BaseClass.driverForFailure.switchTo().alert().accept();
	}
	
	public String getAlertMessage() {
		return BaseClass.driverForFailure.switchTo().alert().getText();		
	}
	
	public void selectItemFromListByText(WebElement list, String itemName) {
		Select select = new Select(list);
		select.selectByVisibleText(itemName);
	}
	
	public void keepMouseOnElement(WebElement element) {
		Actions act = new Actions(BaseClass.driverForFailure);
		act.moveToElement(element).perform();
	}
}
