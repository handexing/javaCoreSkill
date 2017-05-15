package com.handx.thread.join;

public class JoinOne implements Runnable {

	@Override
	public void run() {
		System.out.println("JoinOne start...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("JoinOne finished...");
	}

}
