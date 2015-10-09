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
	public void startDefaultAppium() {
		try {
			System.out.println("Now starting default Appium");
			runtime.exec("appium --session-override");
			Thread.sleep(20000);
		} catch (Exception e) {
			System.out.println("Default Appium is not started");
		}
	}

	/**
	 * stop appium server in Winodws
	 */
	public void stopAppiumServer() {
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (Exception e) {
			System.out.println("Appium Sever not stopped");
		}

	}

	/**
	 * close appium GUI in Winodws
	 */
	public void closeAppiumWindow() throws Exception {
		try {
			runtime.exec("taskkill /IM appium.exe");
		} catch (Exception e) {
			System.out.println("Appium GUI not closed");
		}

	}

	/**
	 * stop appium server in Mac
	 */
	public void stopAppiumServerMac() throws Exception {
		try {
			runtime.exec("killall node");
		} catch (Exception e) {
			System.out.println("Appium Sever not stopped");
		}

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
		try {

			String command = "appium --session-override -p " + port
					+ " --chromedriver-port " + chromePort + " -bp "
					+ bootstrapPort;
			System.out.println(command);
			String output = runtime.exec(command).toString();
			System.out.print(output);
			Thread.sleep(5000);
			if (output.contains("not")) {
				System.out.println("\nAppium is not installed");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Appium is not started");
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

	public void startAppium(String port, String chromePort, String bootstrapPort) {
		// start appium server
		try {
			String command = "appium --session-override -p " + port
					+ " --chromedriver-port " + chromePort + " -bp "
					+ bootstrapPort;
			System.out.println(command);
			String output = runtime.exec(command).toString();
			System.out.println(output);
		} catch (Exception e) {
			System.out.println("Appium is not started");
		}

	}

	public static void main(String[] args) throws Exception {

		AppiumManager ap = new AppiumManager();
		ap.startAppium("4567", "4568", "4569");
	}

}
