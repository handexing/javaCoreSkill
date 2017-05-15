package com.handx.thread.join;

/**
 * 主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码， 只有等到子线程结束了才能执行。
 * 
 * @author handx 908716835@qq.com
 * @date 2017年5月15日 下午4:23:37
 *
 */
public class JoinSimple {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new JoinOne());
		Thread t2 = new Thread(new JoinTwo());

		t1.start();
		t2.start();

		// 等待t1执行完毕t2才能执行
		// 交换注释感受一把
		t1.join();
		// t2.join();
	}

}
