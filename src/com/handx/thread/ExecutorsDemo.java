package com.handx.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ExecutorsDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author handx 908716835@qq.com
 * @date 2017年5月26日 下午10:52:12
 *
 */
public class ExecutorsDemo {

	public static void main(String[] args) {
		final int maxThreadCnt = 5;
		ExecutorService p = Executors.newFixedThreadPool(maxThreadCnt);

		final List<Callable<Integer>> partitions = new ArrayList<Callable<Integer>>();
		// for (final FiveCategory category : fiveCategories) {
		// partitions.add(new Callable<Integer>() {
		// @Override
		// public Integer call() throws Exception {
		// Map<String, List<String>> map = JsoupUtil.getPageUrl(category);
		//
		// Iterator<Entry<String, List<String>>> iterator =
		// map.entrySet().iterator();
		// while (iterator.hasNext()) {
		//
		// Entry<String, List<String>> next = iterator.next();
		// List<String> urls = next.getValue();
		// String key = next.getKey();
		// System.out.println("\n key:" + key);
		// for (String url : urls) {
		// System.out.println(url);
		// }
		//
		// }
		// System.out.println(Thread.currentThread().getName() + "&&&&&&&&&&&");
		// return 0;
		// }
		// });
		// }
		try {
			p.invokeAll(partitions);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
