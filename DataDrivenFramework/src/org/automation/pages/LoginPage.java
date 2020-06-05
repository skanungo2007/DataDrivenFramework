package org.automation.pages;

import java.io.IOException;

import org.automation.Utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void profileLogin(String uname, String pass) throws IOException {
		
		driver.findElement(By.id(Utility.fetchElements("username_id"))).sendKeys(uname);
		
		driver.findElement(By.id(Utility.fetchElements("password_id"))).sendKeys(pass);
		
		driver.findElement(By.id(Utility.fetchElements("login_id"))).click();
		
		
	}


	public void register(String fname, String lname, String phone) throws IOException {
		
		driver.findElement(By.name(Utility.fetchElements("firstname_name"))).sendKeys(fname);
		driver.findElement(By.name(Utility.fetchElements("lastname_name"))).sendKeys(lname);
		driver.findElement(By.xpath(Utility.fetchElements("mobile_xpath"))).sendKeys(phone);
		
		
	}
	
}
