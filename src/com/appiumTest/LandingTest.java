package com.appiumTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LandingTest extends AppiumTest {

	@Test
	public void testLanding() throws IOException {

		// Utils.captureScreen(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// WebElement signinButtonLandingPage =
		// driver.findElement(By.name("sign in"));
		driver.findElement(By.id("com.apptricity.expense:id/txt_user_id"))
				.sendKeys("2");

		driver.findElement(By.id("com.apptricity.expense:id/txt_password"))
				.sendKeys("1");

		driver.findElement(By.id("com.apptricity.expense:id/btn_login"))
				.click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// signinButtonLandingPage.click();

	}

}