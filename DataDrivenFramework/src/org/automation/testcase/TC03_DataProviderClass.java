package org.automation.testcase;

import java.io.IOException;

import org.automation.base.DriverInstance;
import org.automation.datagenerator.DataProviderClass;
import org.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class TC03_DataProviderClass extends DriverInstance{
	
	
	@Test(dataProvider="readExcelTC03", dataProviderClass=DataProviderClass.class)
	public void validateLogin(String uid, String pwd) throws IOException {
		
		LoginPage login = new LoginPage(driver);
		
		login.profileLogin(uid, pwd);
	
	}

}
