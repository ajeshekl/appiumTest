package com.rvsAppiumConfigration;

import java.util.HashMap;
import java.util.Map;

/**
 * DeviceConfiguration - this class contains methods to start adb server, to get
 * connected devices and their information.
 */
public class DeviceConfiguration {

	CommandPrompt cmd = new CommandPrompt();
	Map<String, String> devices = new HashMap<String, String>();

	/**
	 * This method start adb server
	 */
	public void startADB() throws Exception {
		String output = cmd.runCommand("adb start-server");
		String[] lines = output.split("\n");
		if (lines.length == 1)
			System.out.println("adb service already started");
		else if (lines[1].equalsIgnoreCase("* daemon started successfully *"))
			System.out.println("adb service started");
		else if (lines[0].contains("internal or external command"))
			System.out.println("adb path not set in system varibale");
		else if (lines[0].contains("adb server is out of date"))
			System.out
					.println("ADB server didn't ACK \n * failed to start daemon *");
	}

	/**
	 * This method stop adb server
	 */
	public void stopADB() throws Exception {
		cmd.runCommand("adb kill-server");
	}

	/**
	 * This method return connected devices
	 * 
	 * @return hashmap of connected devices information
	 */
	public Map<String, String> getDevices() throws Exception {

		startADB(); // start adb service
		String output = cmd.runCommand("adb devices");
		System.out.print(output);
		String[] lines = output.split("\n");

		if (lines.length <= 1) {
			System.out.println("No Device Connected");
			stopADB();
			System.exit(0); // exit if no connected devices found
		}

		for (int i = 1; i < lines.length; i++) {
			lines[i] = lines[i].replaceAll("\\s+", "");

			if (lines[i].contains("device")) {
				lines[i] = lines[i].replaceAll("device", "");
				String deviceID = lines[i];
				String model = cmd.runCommand(
						"adb -s " + deviceID
								+ " shell getprop ro.product.model")
						.replaceAll("\\s+", "");
				String brand = cmd.runCommand(
						"adb -s " + deviceID
								+ " shell getprop ro.product.brand")
						.replaceAll("\\s+", "");
				String osVersion = cmd.runCommand(
						"adb -s " + deviceID
								+ " shell getprop ro.build.version.release")
						.replaceAll("\\s+", "");
				String deviceName = brand + " " + model;

				devices.put("deviceID" + i, deviceID);
				devices.put("deviceName" + i, deviceName);
				devices.put("osVersion" + i, osVersion);

				System.out.println("Following device is connected");
				System.out.println(deviceID + " " + deviceName + " "
						+ osVersion + "\n");
			} else if (lines[i].contains("unauthorized")) {
				lines[i] = lines[i].replaceAll("unauthorized", "");
				String deviceID = lines[i];

				System.out.println("Following device is unauthorized");
				System.out.println(deviceID + "\n");
			} else if (lines[i].contains("offline")) {
				lines[i] = lines[i].replaceAll("offline", "");
				String deviceID = lines[i];

				System.out.println("Following device is offline");
				System.out.println(deviceID + "\n");
			}
		}
		return devices;
	}

	 public static void main(String[] args) throws Exception {
	 DeviceConfiguration gd = new DeviceConfiguration();
	 gd.startADB();
	 gd.getDevices();
	// //gd.stopADB();
	 }
}
