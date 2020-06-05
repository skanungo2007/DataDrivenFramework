package org.automation.testcase;

import java.io.IOException;

import org.automation.base.DriverInstance;
import org.automation.datagenerator.DataProviderClass;
import org.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class TC04_Registration extends DriverInstance{
	
	
	@Test(dataProvider="readExcelTC04", dataProviderClass=DataProviderClass.class)
	public void registerUser(String fname, String lname, String mobile) throws IOException {
		
		
		LoginPage login = new LoginPage(driver);
		
		login.register(fname, lname, mobile);
	}

}
