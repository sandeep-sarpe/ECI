package com.eci.officeshopper.common;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;


public class Utilities{
	Properties prop = new Properties();
	InputStream input = null;
	
	
	//Get Properties
	public String getProperties(String key) throws IOException{
		//input = new FileInputStream("D:\\1Sandeep\\1UpToDate\\1New_era\\Mobile_app_automation_testing\\Appium\\workspace\\OfficeShopper\\src\\config.properties");
		input = new FileInputStream("src/test/java/config.properties");
		prop.load(input);
		
		return prop.getProperty(key);
	}
	
	//Explicit Wait  
	public void waitUntil(ExpectedCondition<WebElement> expectedCondition,AndroidDriver driver,int time){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(expectedCondition);
	}

}
