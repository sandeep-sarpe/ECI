package com.eci.officeshopper.logoff;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.eci.officeshopper.common.Ignitor;
import com.eci.officeshopper.common.Utilities;

public class TestLogoff {
	AndroidDriver driver;
	Utilities serve = new Utilities();

	@Test (priority = 4)
	public void logoffOfficeShopper() throws IOException, InterruptedException {
		driver = Ignitor.getAndroidDriver();
		
		driver.tap(1, 2142, 481, 1);
		serve.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.name("Log on")), driver, 10);
		Assert.assertTrue(driver.findElementByName("Log on").isDisplayed());
		
	}

}
