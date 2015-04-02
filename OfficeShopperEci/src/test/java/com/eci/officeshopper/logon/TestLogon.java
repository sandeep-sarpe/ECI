package com.eci.officeshopper.logon;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import com.eci.officeshopper.common.Ignitor;
import com.eci.officeshopper.common.Utilities;

public class TestLogon {
	Utilities serve = new Utilities();
	AndroidDriver driver;
	
	@Test(priority=1, groups = "Install")
	public void launchOfficeShopper() throws InterruptedException, IOException{
		 //Get driver
		 driver = Ignitor.getAndroidDriver();
		 
		 //Term&Condition Assert, if Installing first time
		 if(driver.isAppInstalled("eci.officeshopper")){
			 serve.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.name("Terms of use")), driver, 10);
			 Assert.assertTrue(driver.findElementByName("Terms of use").isDisplayed());
		 }
		 else{
			 serve.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.name("Log on")), driver, 10);
			 Assert.assertTrue(driver.findElementByName("Log on").isDisplayed());
		 }
	}
	
	@Test(priority=2, groups = "Install")
	public void registerToOfficeShopper() throws IOException, InterruptedException{
		driver.findElement(By.id("eci.officeshopper:id/acceptButton")).click();
		Assert.assertTrue(driver.findElementByName("Authorization").isDisplayed());
		driver.findElement(By.id("eci.officeshopper:id/auth_view")).sendKeys(serve.getProperties("auth_code"));
		driver.findElement(By.className("android.widget.Button")).click();
		
		serve.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.name("Log on")), driver, 10);
		Assert.assertTrue(driver.findElementByName("Log on").isDisplayed());
	}
	
	@Test (priority = 3, groups = "Logon")
	public void logonToOfficeShopper() throws IOException{
		driver.findElement(By.id("eci.officeshopper:id/login_username")).sendKeys(serve.getProperties("username"));
		driver.findElement(By.id("eci.officeshopper:id/login_password")).sendKeys(serve.getProperties("pwd"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.className("android.widget.Button")).click();
		
		//Need to find a way to remove hard coded user name while finding the element
		serve.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.name("Hello, Saurabh Gangarde")), driver, 10);
		Assert.assertTrue(driver.findElement(By.name("Hello, Saurabh Gangarde")).isDisplayed());
	}
	

}

