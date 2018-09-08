package com.lukcm888.dataaccess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class GetPropValues {

	String result = "";
	InputStream inputStream;
	
	private static final String USERNAME_OPTION = "username";
	private static final String PASSWORD_OPTION = "password";
	
	private static String userName = "";
	String password = "";

	public String getUserName() throws IOException {
		
		userName = getData(USERNAME_OPTION);	
		return userName;
	}
	
	
	public String getPassword() throws IOException {
		
		password = getData(PASSWORD_OPTION);	
		return password;
	}
	
	
	public String getData(String data) throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			// get the property value and print it out
			result = prop.getProperty(data);
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
	
		  
}
