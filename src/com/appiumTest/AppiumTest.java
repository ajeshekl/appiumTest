package com.appiumTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.appiumConfigration.AppiumManager;
import com.appiumConfigration.FrameWorkConstants;

public class AppiumTest {

	WebDriver driver;
	// WebDriver driver1;
	AppiumManager apm = new AppiumManager();

	@BeforeTest
	public void setUp() throws Exception {

		try {
			apm.startDefaultAppium();

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver = FrameWorkConstants.getDriver();

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
		try {
			apm.stopAppiumServerWindows();
			apm.closeAppiumWindow();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}