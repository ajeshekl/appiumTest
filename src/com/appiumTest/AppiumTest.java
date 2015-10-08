package com.appiumTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.appiumConfigration.FrameWorkConstants;

public class AppiumTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {

		driver = FrameWorkConstants.getDriver();

	}

	@AfterTest
	public void tearDown() throws Exception {
		// driver.quit();

//		apm.stopAppiumServer();
//		apm.closeAppiumWindow();

	}

}