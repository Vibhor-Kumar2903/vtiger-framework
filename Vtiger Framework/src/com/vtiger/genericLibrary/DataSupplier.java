package com.vtiger.genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataSupplier {	
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IAutoConstant.PROPERTY_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	public String getDatafromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstant.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		String value = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;		
	}
	
	public void insertDataInExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstant.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IAutoConstant.EXCEL_PATH);
		book.write(fos);
		fos.flush();
		fos.close();		
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataSupplier ds = new DataSupplier();
		ds.insertDataInExcel("sheet1", 0, 2, "Hello");
		System.out.println("pass");
	}
	
	// For DataProvider
	public int getTotalRowCount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstant.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet(sheetname).getLastRowNum();
	}
	
	public short getTotalCellCount(String sheetname, int rownum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstant.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet(sheetname).getRow(rownum).getLastCellNum();	
	}	
}