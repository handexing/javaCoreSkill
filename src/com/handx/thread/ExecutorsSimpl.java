package com.handx.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description: 有返回值的线程
 * @author handx 908716835@qq.com
 * @date 2017年5月13日 下午9:55:19
 *
 */

public class ExecutorsSimpl {

	/**
	 * 可返回值的任务必须实现Callable接口，类似的，无返回值的任务必须Runnable接口。执行Callable任务后，
	 * 可以获取一个Future的对象，在该对象上调用get就可以获取到Callable任务返回的Object了，
	 * 再结合线程池接口ExecutorService就可以实现传说中有返回结果的多线程了。
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Date date1 = new Date();
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
		// 穿件多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < 5; i++) {
			Callable c = new MyCallable(i + " ");
			// 执行任务并获取Future对象
			Future f = pool.submit(c);
			// System.out.println(">>>" + f.get().toString());
			list.add(f);
		}

		// 关闭线程池
		pool.shutdown();

		// 获取所有并发任务的运行结果
		// for (Future f : list) {
		// // 从Future对象上获取任务的返回值，并输出到控制台
		// System.out.println(">>>" + f.get().toString());
		// }

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
}

class MyCallable implements Callable<Object> {

	private String taskNum;

	MyCallable(String taskNum) {
		this.taskNum = taskNum;
	}

	@Override
	public Object call() throws Exception {
		System.out.println(">>>" + taskNum + "任务启动");
		Date dateTmp1 = new Date();
		Thread.sleep(1000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
	}
}
