package com.handx.thread;

/**
 * 
 * start方法启动一个新的线程，新线程会执行run方法，start方法不能被重复调用。
 * run方法就是普通方法，可以重复调用，单独调用会在当前线程中执行run方法，不会启动新的线程。
 * 
 * @author handx 908716835@qq.com
 * @date 2017年5月15日 下午4:31:05
 *
 */
public class StartRunThread {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().getId());
		TestThread t1 = new TestThread("A");
		t1.start();
		TestThread t2 = new TestThread("B");
		t2.run();

		// 运行一下看下打印的日志
	}

}

class TestThread extends Thread {
	
	private String name;

	public TestThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + "：：" + Thread.currentThread().getId());
	}

}