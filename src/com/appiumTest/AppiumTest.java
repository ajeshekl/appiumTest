package com.appiumTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.appiumConfigration.BaseTest;

public class AppiumTest extends BaseTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {

		loadDriver();
		
		//driver = FrameWorkConstants.getDriver();

	}

	@AfterTest
	public void tearDown() throws Exception {
		// driver.quit();

//		apm.stopAppiumServer();
//		apm.closeAppiumWindow();

	}

}