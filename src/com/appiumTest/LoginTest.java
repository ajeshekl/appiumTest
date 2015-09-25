package com.appiumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends AppiumTest {

	@Test
	public void testLogin() {
		
		WebElement signinButtonLandingPage = driver.findElement(By
				.id("com.gudly.android.code:id/signin_button"));
		WebElement emailField = driver.findElement(By
				.id("com.gudly.android.code:id/email_edit_text"));
		WebElement passwordField = driver.findElement(By
				.id("com.gudly.android.code:id/password_edittext"));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		emailField.clear();
		emailField.sendKeys("sanoj@gudly.com");
		passwordField.sendKeys("Test12345");

		signinButtonLandingPage.click();
	}

}