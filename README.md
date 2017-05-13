# 稳固java

## 枚举

## 反射

## 多线程

### 线程的状态

- 创建（new）状态: 准备好了一个多线程的对象
- 就绪（runnable）状态: 调用了start()方法, 等待CPU进行调度
- 运行（running）状态: 执行run()方法
- 阻塞（blocked）状态: 暂时停止执行, 可能将资源交给其它线程使用
- 终止（dead）状态: 线程销毁

**说明**

> 当需要新启动一个线程执行某个任务时，就创建一个线程。但是创建之后线程并不会立马进入就绪状态，因为线程运行需要一些条件，条件满足时，才会进入就绪状态。

> 当线程进入就绪状态时，也并不能立马就能获取CPU的执行时间，CPU可能正在忙着处理别的事情，等需待。当获得CPU的执行时间后，线程进入下一阶段，运行，真正的跑了起来。

> 线程运行过程中，没有遇到任何突发状况，则进入终止状态，线程此时被销毁。线程不能运行下去还可能是“用户主动让线程睡眠”，“用户主动让线程等待”，“同步块阻塞”，这是线程对应的状态：time waiting(睡眠或等待一定时间在执行)、waiting(等待被唤醒)、blocked(阻塞)。

**如下图：**

![运行实例图](https://github.com/handexing/javaCoreSkill/tree/master/img/thread_running.png)

### 线程常用方法

| 方法    | 说明   |
| -------    | -----:  |
|   public void start()   | 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。 |
|   public void run()   | 如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。 |
|   public final void setName(String name)   | 改变线程名称，使之与参数 name 相同。 |
|   public final void setPriority(int priority)   | 更改线程的优先级。 |
|   public final void setDaemon(boolean on)   | 将该线程标记为守护线程或用户线程。 |
|   public final void join(long millisec)   | 等待该线程终止的时间最长为 millis 毫秒。 |
|   public void interrupt()   | 中断线程。 |
|   public final boolean isAlive()   | 测试线程是否处于活动状态。 |
|   public static void yield()   | 暂停当前正在执行的线程对象，并执行其他线程。 |
|   public static void sleep(long millisec)   | 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。 |
|   public static Thread currentThread()   | 返回对当前正在执行的线程对象的引用。 |


### 方法运用实例

- currentThread()方法

> currentThread()方法返回当前线程

```
public static void main(String[] args) {

	// 返回当前线程
	System.out.println(Thread.currentThread().getName());

}
```

- sleep()方法

> 方法sleep()的作用是在指定的毫秒数内让当前“正在执行的线程”休眠（暂停执行）。这个“正在执行的线程”是指this.currentThread()返回的线程。


```
class MyThread extends Thread {
	

	@Override
	public void run() {
		synchronized (MyThread.this) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态");
				Thread.currentThread().sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
		}
	}
	
}

public class ThreadDeom {

	public static void main(String[] args) {

		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		thread1.start();
		thread2.start();

	}

}
```

- yield()方法

> 交出CPU执行权限，让CPU去执行其他线程，她和sleep方法类似不会释放锁。yield不会让线程阻塞，只是让线程重回就绪状态，只需要等待CPU执行时间，获取到就可以重新执行了。

```
class MyThread extends Thread {
	

	@Override
	public void run() {
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

		MyThread thread1 = new MyThread();
		thread1.setName("A");
		MyThread thread2 = new MyThread();
		thread2.setName("B");
		thread1.start();
		thread2.start();

	}

}
```
















