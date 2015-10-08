package com.appiumTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.appiumConfigration.AppiumManager;
import com.appiumConfigration.DeviceConfiguration;
import com.appiumConfigration.FrameWorkConstants;

public class AppiumTest {

	WebDriver driver;
	AppiumManager apm = new AppiumManager();
	DeviceConfiguration dcv = new DeviceConfiguration();

	@BeforeTest
	public void setUp() throws Exception {

		apm.startDefaultAppium();
		dcv.startADB();
		dcv.getDevices();

		driver = FrameWorkConstants.getDriver();

	}

	@AfterTest
	public void tearDown() throws Exception {
		// driver.quit();

		apm.stopAppiumServer();
		apm.closeAppiumWindow();

	}

}