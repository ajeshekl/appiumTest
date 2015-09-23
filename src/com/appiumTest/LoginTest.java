package com.appiumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends AppiumTest {

	@Test
	public void testLogin() {
		WebElement uName = driver
				.findElement(By.id("com.demo:id/usernametext"));
		WebElement pass = driver.findElement(By.id("com.demo:id/passtext"));
		WebElement loginButton = driver.findElement(By
				.id("com.demo:id/loginbtn"));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		uName.sendKeys("sanoj");
		loginButton.click();

	}

}