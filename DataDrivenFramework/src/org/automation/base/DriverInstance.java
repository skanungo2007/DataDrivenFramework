package org.automation.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.automation.Utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class DriverInstance {

	
	protected WebDriver driver;
	
	
	@BeforeMethod
	public void setBrowser() throws IOException {
		
		if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			
			
		} else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			
		} else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			
			driver = new EdgeDriver();
			
		} else {
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(Utility.fetchProperty("URL").toString());
		
		
		
	}
	
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		
		System.out.println("Execution complete");
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		Thread.sleep(2000);
		
		driver.quit();
	}
}
