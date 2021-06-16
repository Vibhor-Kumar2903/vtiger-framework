package com.vtiger.testScript;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.BaseClass;

@Listeners(com.vtiger.genericLibrary.ExecutionMonitor.class)
public class LoginToVtigerTest extends BaseClass{
	
		@Test
		public void loginTest() throws IOException {		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"));
		
		//System.out.println(driver.getTitle());
		//System.out.println(ds.getDatafromExcel("TestData", 1, 2));
		
		if (driver.getTitle().equals(ds.getDatafromExcel("TestData", 1, 2))) {
			Reporter.log("Login successfully.",true);
		}else {
			Reporter.log("Login failed.",true);			
		}		
	}
}