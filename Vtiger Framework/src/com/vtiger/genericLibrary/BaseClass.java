package com.vtiger.genericLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.vtiger.elementRepository.HomePage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver driverForFailure; 
	public DataSupplier ds = new DataSupplier();
	public SoftAssert sa = new SoftAssert();
	public CommonUtility cu = new CommonUtility();
	
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("------------------Browser Launching------------------");
		if (ds.getDataFromProperties("browser").equals("chrome")) {
			driver = new ChromeDriver();
		}else if (ds.getDataFromProperties("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driverForFailure = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
//	@Parameters ("browser")
//	@BeforeClass (alwaysRun = true)
//	public void configBC(String browser) throws IOException {
//		System.out.println("------------------Browser Launching------------------");
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		}else if (browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		
//		driverForFailure = driver;
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get(ds.getDataFromProperties("url"));		
//	}
	
	@BeforeMethod (alwaysRun = true)
	public void configBM() throws IOException {
		System.out.println("-----------------Login to Application-----------------");
		driver.get(ds.getDataFromProperties("url"));		
		sa.assertEquals(driver.getTitle(), ds.getDataFromProperties("loginTitle"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(ds.getDataFromProperties("username"));
		lp.getPassword().sendKeys(ds.getDataFromProperties("password"));
		lp.getLoginButton().click();
		sa.assertAll("Before method soft assert..");
	}
	
	@AfterMethod (alwaysRun = true)
	public void configAM() throws IOException {
		System.out.println("-----------------Logout from Application-----------------");
		HomePage hp = new HomePage(driver);
		cu.keepMouseOnElement(hp.getlogoutDropDown());
		hp.getlogoutLink().click();
		sa.assertEquals(driver.getTitle(), ds.getDataFromProperties("loginTitle"));
		sa.assertAll("After method soft assert..");
	}
	
	@AfterClass (alwaysRun = true)
	public void configAC() {
		System.out.println("--------------------Browser close---------------------");
		driver.quit();
	}
}