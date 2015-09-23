package com.appiumConfigration;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FrameWorkConstants {

	public static Properties getConfigrtions()
	{
		Properties prop = new Properties();
		InputStream input = null;
		try
		{
			input = FrameWorkConstants.class.getResourceAsStream("config.properties");
			prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
	public static WebDriver getDriver()
	{
		WebDriver driver = null;
		try
		{
			Properties prop = getConfigrtions();

			DesiredCapabilities capabilities = new DesiredCapabilities();
			StringBuilder errorLog = new StringBuilder();
			String deviceName="",version="",platformName="",appPath="",appPackage="",appActivity="";
			deviceName   = (String)prop.get("deviceName");
			version      = (String)prop.get("version");
			platformName = (String)prop.get("platformName");
			appPath      = (String)prop.get("appPath");
			appPackage   = (String)prop.get("appPackage");
			appActivity  = (String)prop.get("appActivity");

			if(deviceName!=null&&!deviceName.trim().equals(""))
				capabilities.setCapability("deviceName",deviceName);
			else
				errorLog.append("Device Name");
			
			if(version!=null&&!version.trim().equals(""))
				capabilities.setCapability(CapabilityType.VERSION,version);
			else
			{
				if(errorLog.length()>0)
					errorLog.append(",");
				errorLog.append("Version");
			}
			
			if(platformName!=null&&!platformName.trim().equals(""))
				capabilities.setCapability("platformName",platformName);
			else
			{
				if(errorLog.length()>0)
					errorLog.append(",");
				errorLog.append("Platforn Name");
			}
				
			
			if(appPath!=null&&!appPath.trim().equals(""))
			{
				capabilities.setCapability("app", appPath);
			}
			else
			{
				if(appPackage!=null&&!appPackage.trim().equals("") && appActivity!=null&&!appActivity.trim().equals(""))
				{
					capabilities.setCapability("appPackage", appPackage);
					capabilities.setCapability("appActivity", appActivity);
				}
				else
				{
					if(errorLog.length()>0)
						errorLog.append(",");
					errorLog.append("Application Path Or Application Package&Activity");
				}
			}
			
				
			if(errorLog.length()==0)
				driver = new RemoteWebDriver(new URL(prop.get("driverURL").toString()), capabilities);
			else
			{
				System.out.println("Missing "+errorLog.toString()+" in Configurations!!");
				System.exit(0);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}
	
}
