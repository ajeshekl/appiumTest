package com.appiumTest;
 
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appiumConfigration.FrameWorkConstants;
 
public class AppiumTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		
		driver = FrameWorkConstants.getDriver();
	}
	
	@Test
	public void testLogin(){
		WebElement uName=driver.findElement(By.id("com.demo:id/usernametext"));
		WebElement pass=driver.findElement(By.id("com.demo:id/passtext"));
		WebElement loginButton=driver.findElement(By.id("com.demo:id/loginbtn"));
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		uName.sendKeys("sanoj");
		pass.sendKeys("sanoj");
		loginButton.click();
		
	}
	
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
}