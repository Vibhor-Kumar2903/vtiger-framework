package com.vtiger.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.DataSupplier;

public class DemoDataProvider {

	@Test(dataProvider = "provideCredentials")
	public void loginToApp(String username, String password) {
		System.out.println("Username : "+username);
		System.out.println("Password : "+password);
	}

	@DataProvider
	public Object[][] provideCredentials() throws EncryptedDocumentException, IOException{
		
		DataSupplier ds = new DataSupplier();
		
		Object[][] objArr = new Object[10][2];
		
		int rowCount = ds.getTotalRowCount("DataProvider");
		
		for (int i = 0; i <= rowCount; i++) {
			objArr[i][0] = ds.getDatafromExcel("DataProvider", i, 0);
			objArr[i][1] = ds.getDatafromExcel("DataProvider", i, 1);
		}
		return objArr;
	}
}