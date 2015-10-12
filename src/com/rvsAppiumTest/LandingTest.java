package com.rvsAppiumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LandingTest extends AppiumTest {

	@Test
	public void testLanding() throws IOException {

		// Utils.captureScreen(driver);

		// WebElement signinButtonLandingPage =
		// driver.findElement(By.name("sign in"));

		WebElement userID = driver.findElement(By
				.id("com.apptricity.expense:id/txt_user_id"));

		userID.sendKeys("2");

		// driver.findElement(By.id("com.apptricity.expense:id/txt_password"))
		// .sendKeys("1");
		//
		// driver.findElement(By.id("com.apptricity.expense:id/btn_login"))
		// .click();

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// signinButtonLandingPage.click();

	}
}