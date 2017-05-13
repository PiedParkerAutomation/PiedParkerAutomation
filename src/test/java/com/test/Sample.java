package com.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import bsh.Capabilities;

public class Sample {
	IOSDriver<WebElement> driver;
	WebDriverWait wait;

	@Test
	public void sampleTest() {
		//driver.get("http://www.google.com");
		
		driver.findElement(By.name("E-mail")).sendKeys("renuka.madhave@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("abc123");
		driver.findElement(By.name("Sign-In")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("NO")));
		//driver.findEleme nt(By.name("NO")).click();
		

	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		File appFile = new File("/Users/rmadhave/Documents/PiedParker/PiedParkerAutomation/src/test/resources/iPiedParker.app");
		//System.out.println(appFile.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
		//cap.setCapability(MobileCapabilityType.UDID, "5d06bc39131ff82227bac1d3729017aa3c1d57a4");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

		driver = new IOSDriver<WebElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 wait = new WebDriverWait(driver, 30);
		
		
	}

	@AfterTest
	public void afterTest() {
		//quits the driver
		//driver.quit();
	}

}
