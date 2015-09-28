package com.appiumTest;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.appiumConfigration.FrameWorkConstants;

public class AppiumTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		driver = FrameWorkConstants.getDriver();
	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

}