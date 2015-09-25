package com.appiumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LandingTest extends AppiumTest {

	@Test
	public void testLanding() {
		
		WebElement signinButtonLandingPage = driver.findElement(By
				.id("com.gudly.android.code:id/signin_button"));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		signinButtonLandingPage.click();
		

	}

}