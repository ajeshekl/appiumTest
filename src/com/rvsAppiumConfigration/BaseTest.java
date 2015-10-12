package com.rvsAppiumConfigration;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest implements Runnable {
	protected BaseTest[] deviceThreads;
	protected int numOfDevices;
	protected String deviceId;
	protected String deviceName;
	protected String osVersion;
	protected String port;
	protected String Url;
	protected Thread t;
	protected int deviceCount;

	AppiumManager appiumMan = new AppiumManager();
	static Map<String, String> devices = new HashMap<String, String>();
	static DeviceConfiguration deviceConf = new DeviceConfiguration();

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

	public BaseTest() {
		try {
			devices = deviceConf.getDevices();
			deviceCount = devices.size() / 3;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BaseTest(int i) {
		int deviceNumber = (i + 1);
		this.deviceId = devices.get("deviceID" + deviceNumber);
		this.deviceName = devices.get("deviceName" + deviceNumber);
		this.osVersion = devices.get("osVersion" + deviceNumber);
	}

	public void loadDriver(WebDriver driver) {

		try {

			// Start appium server

			//port = appiumMan.startAppium();
			
			appiumMan.startDefaultAppium();
			
			// create appium driver instance

			Properties prop = getConfigrtions();
			DesiredCapabilities capabilities = DesiredCapabilities.android();

			String appPackage = "", appActivity = "", appName = "", appPath = "", platfomName = "";

			platfomName = (String) prop.get("platformName");
			appPackage = (String) prop.get("appPackage");
			appActivity = (String) prop.get("appActivity");
			appName = (String) prop.get("appName");
			appPath = System.getProperty("user.dir") + "/src/apps/" + appName;

			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformName", platfomName);
			capabilities.setCapability(CapabilityType.VERSION, osVersion);
			capabilities.setCapability("udid", deviceId);
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
			capabilities.setCapability("app", appPath);

//			driver = new RemoteWebDriver(new URL("http://0.0.0.0:" + port
//					+ "/wd/hub"), capabilities);
			
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4729/wd/hub"), capabilities);
			
			System.out.println("Now starting default Appium ENDS");
						
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroyDriver() {
		// driver.quit();
		try {
			deviceConf.stopADB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

	public void run() {
	}

	public <c> void execute() {
		Class<?> c;
		try {
			int startMethod = 0;
			String className = this.getClass().toString();
			System.out.println("class : " + className);
			className = className.replace("class ", "");
			System.out.println("class : " + className);
			// Get extended class name
			c = Class.forName(className);
			System.out.println("class : " + c);

			// Get start method
			Method[] m = c.getMethods();
			System.out.println("methods: " + m.length);
			for (int i = 0; i < m.length; i++) {
				// System.out.println("methods: "+m[i]);
				if (m[i].toString().contains("start")) {
					startMethod = i;
					break;
				}
			}
			System.out.println("methods: " + m[startMethod]);
			// get constructor
			Constructor<?> cons = c.getConstructor(Integer.TYPE);
			System.out.println("cons: " + cons);

			System.out.println("deviceCount: " + deviceCount);
			// Create array of objects
			Object obj = Array.newInstance(c, deviceCount);
			for (int i = 0; i < deviceCount; i++) {
				Object val = cons.newInstance(i);
				Array.set(obj, i, val);
			}

			for (int i = 0; i < deviceCount; i++) {
				Object val = Array.get(obj, i);
				m[startMethod].invoke(val);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
