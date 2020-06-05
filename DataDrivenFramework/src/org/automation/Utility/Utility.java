package org.automation.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {

	
	public static Object fetchProperty(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./config/config.properties");
		
		Properties property = new Properties();
		
		property.load(fis);
		
		return property.get(key);

		
	}
	


	public static String fetchElements(String key) throws IOException {

		FileInputStream fis = new FileInputStream("./config/element.properties");
		
		Properties property = new Properties();
		
		property.load(fis);
		
		return property.get(key).toString();
	}


	
}
