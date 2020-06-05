package org.automation.datagenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	
	@DataProvider(name="readExcelTC03")
	public static Object[][] getDataLog() throws IOException{
		
		File file = new File("./TestData/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Login");
		
		
		int numberOfData = sheet.getPhysicalNumberOfRows();
		
		XSSFRow row = sheet.getRow(0);
		
		int numberOfCells = row.getPhysicalNumberOfCells();
		
		
		Object[][] logData = new Object[numberOfData][numberOfCells];
		
		for(int i=0; i<numberOfData; i++) {
			
			row = sheet.getRow(i);
			
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			
			logData[i][0] = username.getStringCellValue();
			logData[i][1] = password.getStringCellValue();
		}
		
		fis.close();
		
		return logData;

		
	}
	
	
	@DataProvider(name="readExcelTC04")
	public static Object[][] getDataReg() throws IOException{
		
		
		File file = new File("./TestData/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Register");
		
		int numberOfData = sheet.getPhysicalNumberOfRows();
		
		XSSFRow row = sheet.getRow(0);
		
		int numberOfCells = row.getPhysicalNumberOfCells();
		
		Object[][] regData = new Object[numberOfData][numberOfCells];
		
		
		for(int i=0; i<numberOfData; i++) {
			
			row = sheet.getRow(i);
			
			XSSFCell fname = row.getCell(0);
			XSSFCell lname = row.getCell(1);
			XSSFCell phone = row.getCell(2);
			
			regData[i][0] = fname.getStringCellValue();
			regData[i][1] = lname.getStringCellValue();
			regData[i][2] = phone.getStringCellValue();
			
			
		}
		
		
		
		fis.close();
		
		return regData;

		
	}

}
