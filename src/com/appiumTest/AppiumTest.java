package com.appiumTest;
 
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appiumTest.Configrations.FrameWorkConstants;
 
public class AppiumTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		
		driver = FrameWorkConstants.getDriver();
	}
	
	
	@Test
	public void Cal(){
		WebElement uName=driver.findElement(By.name("Username"));
		WebElement pass=driver.findElement(By.name("Username"));
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		uName.sendKeys("ajesh");
	}
	
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
}