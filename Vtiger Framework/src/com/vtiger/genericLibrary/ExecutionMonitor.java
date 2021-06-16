package com.vtiger.genericLibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExecutionMonitor implements ITestListener{
	
	public void onTestFailure(ITestResult args) {
		String name = args.getName();
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String timeStamp = sdf.format(Calendar.getInstance().getTime()).
				replace("/", "_").replace(" ", "_").replace(":", "_");
		
		EventFiringWebDriver efwd = new EventFiringWebDriver(BaseClass.driverForFailure);
		File screenShot = efwd.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenShot, new File("./screenshot/"+name+timeStamp+".png"));
		}catch(Exception e) {
			System.out.println("Exception occurs");
		}		
	}
}