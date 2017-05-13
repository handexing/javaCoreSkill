package com.handx.thread;

/**
 * @Description: 实现runnable
 * @author handx 908716835@qq.com
 * @date 2017年5月4日 上午10:21:03
 *
 */
public class RunnableDemo implements Runnable {

	public static void main(String[] args) {
		RunnableDemo r = new RunnableDemo();
		Thread thread = new Thread(r);
		thread.start();
		System.out.println("run end.");
	}

	@Override
	public void run() {
		System.out.println("hello runnable!");
	}
}
