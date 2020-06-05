package org.automation.testcase;

import java.io.IOException;

import org.automation.base.DriverInstance;
import org.automation.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_StaticDataProvider extends DriverInstance {

	
	@Test(dataProvider="static")
	public void validateLogin(String uid, String pwd) throws IOException {
		
		LoginPage login = new LoginPage(driver);
		
		login.profileLogin(uid, pwd);
		
		
		
	}
	
	
	
	@DataProvider(name="static")
	public Object[][] getData(){
		
		return new Object[][] {
			
			{"uname1", "pass1"},
			{"uname2", "pass2"},
			{"uname3", "pass3"}
			
		};
		
		
	}

}