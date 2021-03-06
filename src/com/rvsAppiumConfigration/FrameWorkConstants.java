package com.rvsAppiumConfigration;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FrameWorkConstants {

	public static Properties getConfigrtions() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = FrameWorkConstants.class
					.getResourceAsStream("config.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static WebDriver getDriver() throws Exception {
		WebDriver driver = null;
		DeviceConfiguration dcv = new DeviceConfiguration();
		AppiumManager apm = new AppiumManager();
		try {
			apm.startDefaultAppium();
			dcv.startADB();
			dcv.getDevices();

			Properties prop = getConfigrtions();

			DesiredCapabilities capabilities = new DesiredCapabilities();
			StringBuilder errorLog = new StringBuilder();
			String testDevice = "", deviceName = "", version = "", platformName = "", appPackage = "", appActivity = "", udId = "", bundleId = "", appName = "", appPath = "";

			testDevice = (String) prop.get("testDevice");
			deviceName = (String) prop.get("deviceName");
			version = (String) prop.get("version");
			platformName = (String) prop.get("platformName");
			appPackage = (String) prop.get("appPackage");
			appActivity = (String) prop.get("appActivity");
			udId = (String) prop.get("udid");
			bundleId = (String) prop.get("bundleId");
			appName = (String) prop.get("appName");

			if (appName != null && !appName.trim().equals(""))
				appPath = System.getProperty("user.dir") + "/src/app/"
						+ appName;

			if (deviceName != null && !deviceName.trim().equals(""))
				capabilities.setCapability("deviceName", deviceName);
			else
				errorLog.append("Device Name");

			if (version != null && !version.trim().equals(""))
				capabilities.setCapability(CapabilityType.VERSION, version);
			else {
				if (errorLog.length() > 0)
					errorLog.append(",");
				errorLog.append("Version");
			}

			if (platformName != null && !platformName.trim().equals(""))
				capabilities.setCapability("platformName", platformName);
			else {
				if (errorLog.length() > 0)
					errorLog.append(",");
				errorLog.append("Platforn Name");
			}

			if (testDevice != null && testDevice.equals("android")) {
				if (appPath != null && !appPath.trim().equals("")) {
					capabilities.setCapability("app", appPath);
				} else {
					if (appPackage != null && !appPackage.trim().equals("")
							&& appActivity != null
							&& !appActivity.trim().equals("")) {
						capabilities.setCapability("appPackage", appPackage);
						capabilities.setCapability("appActivity", appActivity);
					} else {
						if (errorLog.length() > 0)
							errorLog.append(",");
						errorLog.append("Application Path Or Application Package&Activity");
					}
				}
			}

			else// IOS
			{
				capabilities.setCapability("newCommandTimeout", 180);
				capabilities.setCapability("udid", udId);

				if (appPath != null && !appPath.trim().equals("")) {
					capabilities.setCapability("app", appPath);
				} else {
					if (bundleId != null && !bundleId.trim().equals(""))
						capabilities.setCapability("bundleId", bundleId);
					else {
						if (errorLog.length() > 0)
							errorLog.append(",");
						errorLog.append("Application Path Or BundleId");
					}
				}
			}

			if (errorLog.length() == 0) {
				driver = new RemoteWebDriver(new URL(prop.get("driverURL")
						.toString()), capabilities);
			} else {
				System.out.println("Missing " + errorLog.toString()
						+ " in Configurations!!");
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

}
