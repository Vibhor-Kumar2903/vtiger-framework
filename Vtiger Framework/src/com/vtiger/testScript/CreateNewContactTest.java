package com.vtiger.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.elementRepository.ContactInfoPage;
import com.vtiger.elementRepository.ContactPage;
import com.vtiger.elementRepository.CreatNewContactPage;
import com.vtiger.elementRepository.HomePage;
import com.vtiger.genericLibrary.BaseClass;

@Listeners(com.vtiger.genericLibrary.ExecutionMonitor.class)
public class CreateNewContactTest extends BaseClass{
	
	@Test
	public void createNewContact() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		CreatNewContactPage cncp = new CreatNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		
		sa.assertEquals(driver.getTitle(), ds.getDataFromProperties("homeTitle"));
		
		hp.getContactLink().click();
		sa.assertEquals(driver.getTitle(), ds.getDatafromExcel("TestData", 2, 5));
		
		cp.getcreateContactImg().click();
		sa.assertEquals(cncp.getPageHead().getText(), ds.getDatafromExcel("TestData", 2, 6));
		
		cncp.getlastNameTB().sendKeys(ds.getDatafromExcel("TestData", 2, 3));
		
		cncp.getsaveBT().click();
	
		String actualSuccessMsg = cip.getcontactSucessMsg().getText();
		Assert.assertTrue(actualSuccessMsg.contains(ds.getDatafromExcel("TestData", 2, 4)));
		Reporter.log("Contact created successfully.",true);
		
		sa.assertAll("Test level, soft assert");
	}
}