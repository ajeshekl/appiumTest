package com.appiumConfigration;

/**
 * Appium Manager - this class contains method to start and stops appium server
 */
public class AppiumManager {

	CommandPrompt cp = new CommandPrompt();
	AvailablePorts ap = new AvailablePorts();
	Runtime runtime = Runtime.getRuntime();
	/**
	 * start appium with default arguments
	 */
	public void startDefaultAppium(){
		try {
			System.out.println("Now starting default Appium");
		    runtime.exec("appium --session-override");
		    Thread.sleep(20000);
			System.out.println("started");
		}
		catch (Exception e) {
			System.out.println("Default Appium is not started");
		}
	}

	/**
	 * stop appium server in Winodws
	 */
	public void stopAppiumServer() throws Exception {
		cp.runCommand("taskkill /F /IM node.exe");
		Thread.sleep(5000);
	}

	public void closeAppiumWindow() throws Exception {

		cp.runCommand("taskkill /IM appium.exe");
		Thread.sleep(5000);

	}

	/**
	 * stop appium server in Mac
	 */
	public void stopAppiumServerMac() throws Exception {
		cp.runCommand("killall node");
		Thread.sleep(5000);
	}

	/**
	 * start appium with auto generated ports : appium port, chrome port, and
	 * bootstap port
	 */
	public String startAppium() throws Exception {
		// start appium server
		String port = ap.getPort();
		String chromePort = ap.getPort();
		String bootstrapPort = ap.getPort();

		String command = "appium --session-override -p " + port
				+ " --chromedriver-port " + chromePort + " -bp "
				+ bootstrapPort;
		System.out.println(command);
		String output = cp.runCommand(command);
		System.out.println(output);
		Thread.sleep(5000);

		if (output.contains("not")) {
			System.out.println("\nAppium is not installed");
			System.exit(0);
		}
		return port;

	}

	/**
	 * start appium with modified arguments : appium port, chrome port, and
	 * bootstap port as user pass port number
	 * 
	 * @param appium
	 *            port
	 * @param chrome
	 *            port
	 * @param bootstrap
	 *            port
	 */

	public void startAppium(String port, String chromePort, String bootstrapPort)
			throws Exception {
		String command = "appium --session-override -p " + port
				+ " --chromedriver-port " + chromePort + " -bp "
				+ bootstrapPort;
		System.out.println(command);
		String output = cp.runCommand(command);
		System.out.println(output);
	}

	public static void main(String[] args) throws Exception {

		AppiumManager ap = new AppiumManager();
		ap.startAppium();
	}

}
