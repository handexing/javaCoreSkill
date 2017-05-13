package com.handx.thread;

/**
 * @Description: 继承Thread
 * @author handx 908716835@qq.com
 * @date 2017年5月4日 上午10:21:31
 *
 */
class MyThread extends Thread {
	
	@Override
	public void run() {
		super.run();
		System.out.println("hello MyThread!");
	}
	
}

public class ThreadDeom {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		System.out.println("run end.");
	}
}