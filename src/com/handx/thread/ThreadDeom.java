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
		// sleep
		// synchronized (MyThread.this) {
		// try {
		// System.out.println("线程" + Thread.currentThread().getName() +
		// "进入睡眠状态");
		// Thread.currentThread().sleep(10000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
		// }

		if ("A".equals(Thread.currentThread().getName())) {
			System.out.println(Thread.currentThread().getName() + "::让出CPU权限！");
			Thread.currentThread().yield();
		}
		System.out.println("A让出了，执行B，然后在执行A");
		boolean alive = Thread.currentThread().isAlive();
		System.out.println(alive);

	}
	
}

public class ThreadDeom {

	public static void main(String[] args) {

		// 返回当前线程
		// System.out.println(Thread.currentThread().getName());
		//
		MyThread thread1 = new MyThread();
		thread1.setName("A");
		MyThread thread2 = new MyThread();
		thread2.setName("B");
		thread1.start();
		thread2.start();

	}

}