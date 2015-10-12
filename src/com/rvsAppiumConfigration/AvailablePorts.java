package com.rvsAppiumConfigration;

import java.net.ServerSocket;

public class AvailablePorts {

	/**
	 * Describing available ports
	 */
	
	public String getPort() throws Exception {
		ServerSocket socket = new ServerSocket(0);
		socket.setReuseAddress(true);
		String port = Integer.toString(socket.getLocalPort());
		System.out.print(port);
		socket.close();
		return port;
	}
}
