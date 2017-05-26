package com.handx.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor extends Thread {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 5; i++) {
			service.execute(new MyExecutor(i));
		}
		System.out.println("submit finish");
		service.shutdown();
	}

	private int index;

	public MyExecutor(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		try {
			System.out.println(index + " start....");
			Thread.sleep((int) (Math.random() * 10000));
			System.out.println(index + " end....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
