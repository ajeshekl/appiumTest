package com.appiumTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Utilities.Utils;

public class LandingTest extends AppiumTest {

	@Test
	public void testLanding() throws IOException {
		
		Utils.captureScreen(driver);
	
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		WebElement signinButtonLandingPage = driver.findElement(By.name("sign in"));

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		signinButtonLandingPage.click();

	}

}