package com.eci.officeshopper.common;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.eci.officeshopper.common.Utilities;

//This class will responsible for launching desired mobile application 
public class Ignitor {
	private static AndroidDriver driver;
	
	private Ignitor() throws IOException{
		//No one can create instance of Ignitor 
	}

	
	//Get singleton Android driver
	public static AndroidDriver getAndroidDriver() throws IOException,InterruptedException {
		if (driver == null){
			Utilities serve = new Utilities();
			DesiredCapabilities  capabilities;
			
			//Assemble desired capabilities (JSON)
			File app = new File(serve.getProperties("app"));
			System.out.println("################## "+app.getAbsolutePath());
			capabilities = new DesiredCapabilities("appWaitActivity", null, null);
			capabilities.setCapability(CapabilityType.BROWSER_NAME, serve.getProperties("browser_name"));
			capabilities.setCapability("deviceName", serve.getProperties("device_name"));
			capabilities.setCapability("platformVersion", serve.getProperties("platformVersion"));
			capabilities.setCapability("platformName", serve.getProperties("platformName"));
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", serve.getProperties("appPackage"));
			capabilities.setCapability("appActivity", serve.getProperties("appActivity"));
			capabilities.setCapability("appWaitActivity", serve.getProperties("appWaitActivity"));
			
			//Create new AndroidDriver
			driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		return driver;
	}
	
	//Assemble desired capabilities (JSON)
	/*public DesiredCapabilities assembleDesiredCap() throws IOException{
		Utilities serve = new Utilities();
		File app = new File(serve.getProperties("app"));
		System.out.println("################## "+app.getAbsolutePath());
		capabilities = new DesiredCapabilities("appWaitActivity", null, null);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, serve.getProperties("browser_name"));
		capabilities.setCapability("deviceName", serve.getProperties("device_name"));
		capabilities.setCapability("platformVersion", serve.getProperties("platformVersion"));
		capabilities.setCapability("platformName", serve.getProperties("platformName"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", serve.getProperties("appPackage"));
		capabilities.setCapability("appActivity", serve.getProperties("appActivity"));
		capabilities.setCapability("appWaitActivity", serve.getProperties("appWaitActivity"));
				
		return capabilities;
	}*/
	
	

}
