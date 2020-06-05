package org.automation.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.base.DriverInstance;
import org.automation.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC02_DataFromExcel extends DriverInstance {
	
	
	
	@Test(dataProvider="readExcel")
	public void validateLogin(String uid, String pwd) throws IOException {
		
		LoginPage login = new LoginPage(driver);
		
		login.profileLogin(uid, pwd);
	
	}
	
	
	
	@DataProvider(name="readExcel")
	public Object[][] getData() throws IOException{
		
		File file = new File("./TestData/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Login");
		
		
		int numberOfData = sheet.getPhysicalNumberOfRows();
		
		XSSFRow row = sheet.getRow(0);
		
		int numberOfCells = row.getPhysicalNumberOfCells();
		
		
		Object[][] data = new Object[numberOfData][numberOfCells];
		
		for(int i=0; i<numberOfData; i++) {
			
			row = sheet.getRow(i);
			
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			
			data[i][0] = username.getStringCellValue();
			data[i][1] = password.getStringCellValue();
		}
		
		fis.close();
		
		return data;

		
	}

}
