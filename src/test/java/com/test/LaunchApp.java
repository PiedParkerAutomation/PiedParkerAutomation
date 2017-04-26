package com.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		// File f = new File("/Users/amisaunders/Desktop/UdemyAppium/iOSApps/iPiedParkeripa");
		File f = new File("src");
		File fs = new File(f, "iPiedParker.ipa");
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		// cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		IOSDriver driver = new IOSDriver<WebElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		// IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

}
