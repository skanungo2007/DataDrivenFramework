package org.automation.assertion;

import org.openqa.selenium.WebDriver;

public class Compare {

	
	
	public boolean verifyPage(WebDriver driver, String expURL) {
		
		boolean flag = false;
		
		if(driver.getCurrentUrl().equalsIgnoreCase(expURL)) {
			
			flag = true;
		}
		
		return flag;
	}
	
	
	public boolean verifyTitle(WebDriver driver, String expTitle) {
		
		boolean flag = false;
		
		if(driver.getTitle().equalsIgnoreCase(expTitle)) {
			
			flag = true;
		}
		
		return flag;
	}
	
}
