package com.appiumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LandingTest extends AppiumTest {

	@Test
	public void testLanding() {

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		WebElement signinButtonLandingPage = driver.findElement(By.name("sign in"));

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		signinButtonLandingPage.click();

	}

}