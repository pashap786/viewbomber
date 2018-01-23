package com.app;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainOne {

	private static String test_url = "https://www.youtube.com/watch?v=yApLZGQ0J_E";
	
	public static void main(String[] args) {
		System.out.println("Enter a url:");
		Scanner in = new Scanner(System.in);
		String url = in.nextLine();
		System.out.println("Enter a times to open:");
		int times = in.nextInt();
		for (int x = 0; x <= times; x++) {

			BrowserThread bt = new BrowserThread(test_url);
			bt.run();
		}

	}

	public static void availablePortPath() {
		Scanner sc = new Scanner(System.in);

		boolean portAvailable = false;

		while (!portAvailable) {
			System.out.println("Enter a port to use");
			int numbIn = sc.nextInt();
			portAvailable = availablePorts(numbIn);

			if (portAvailable) {
				System.out.println("Port is available: " + numbIn);
			}

		}
	}

	public static void exit() {
		System.exit(-1);
	}

	public static boolean availablePorts(Integer in) {
		boolean available = false;
		Socket Skt;
		String host = "localhost";
		try {
			Skt = new Socket(host, in);

		} catch (UnknownHostException e) {
			System.out.println("Exception occured" + e);
		} catch (IOException e) {
			return true;
		}

		return false;
	}

}
