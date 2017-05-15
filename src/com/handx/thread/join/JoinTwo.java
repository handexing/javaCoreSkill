package com.handx.thread.join;

public class JoinTwo implements Runnable {

	@Override
	public void run() {
		System.out.println("JoinTwo start...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("JoinTwo finished...");
	}

}
