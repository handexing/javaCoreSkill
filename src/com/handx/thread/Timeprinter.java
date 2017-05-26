package com.handx.thread;

import java.util.Date;

public class Timeprinter implements Runnable {

	public static void main(String[] args) {
		Thread a = new Thread(new Timeprinter(1000, "A"));
		a.start();
		Thread b = new Thread(new Timeprinter(3000, "B"));
		b.start();
	}
	int pauseTime;

	String name;

	public Timeprinter(int pauseTime, String name) {
		super();
		this.pauseTime = pauseTime;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(name + ":" + new Date(System.currentTimeMillis()));
				Thread.sleep(pauseTime);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
