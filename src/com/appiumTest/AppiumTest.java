package com.appiumTest;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appiumConfigration.FrameWorkConstants;

public class AppiumTest {

	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		driver = FrameWorkConstants.getDriver();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}