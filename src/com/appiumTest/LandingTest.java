package com.appiumTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;

public class LandingTest extends AppiumTest {

	@Test
	public void testLanding() throws IOException {
		
		String imageName = System.currentTimeMillis() + ".png";
		
		driver1 = new Augmenter().augment(driver);
		File file = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("//Users//Rahul//git//appiumTest//Screenshot" + imageName));

//		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//
//		WebElement signinButtonLandingPage = driver.findElement(By.name("sign in"));
//
//		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//
//		signinButtonLandingPage.click();

	}

}