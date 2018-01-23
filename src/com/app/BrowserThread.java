package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BrowserThread implements Runnable {

	private String url;

	public BrowserThread(String url) {
		this.url = url;
	}

	@Override
	public void run() {

		Runtime runtime = Runtime.getRuntime();
		Process p;
		try {
			p = runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			System.out.println(p.isAlive());
			Date date = new Date();
			DateFormat formatter = new SimpleDateFormat("HHmmssSSS");
			String tag = "test" + formatter.format(date);

			System.out.println("opening url");
			Thread.sleep(5000L);
			killItnow();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	public long waittime() {
		Random r = new Random();
		long l = r.nextInt(100000);

		while (l < 5000) {
			l = r.nextInt(100000);
		}
		System.out.println("wait time:" + l);
		return l;

	}

	public void killItnow() {
		System.out.println("attempting to kill");
		try {
			Process pv = Runtime.getRuntime().exec("TASKKILL /f /t /im iexplore.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
