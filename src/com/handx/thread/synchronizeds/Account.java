package com.handx.thread.synchronizeds;

/**
 * 如果此类用于单线程应用程序，不会有任何问题。但是，在多线程应用程序的情况中，不同的线程就有可能同时访问同一个 Account
 * 对象，比如说一个联合帐户的所有者在不同的 ATM
 * 上同时进行访问。在这种情况下，存入和支出就可能以这样的方式发生：一个事务被另一个事务覆盖。这种情况将是灾难性的。但是，Java
 * 编程语言提供了一种简单的机制来防止发生这种覆盖。每个对象在运行时都有一个关联的锁。这个锁可通过为方法添加关键字 synchronized 来获得。
 *
 */
public class Account {

	String holderName;
	float amount;

	public Account(String name, float amt) {
		holderName = name;
		amount = amt;
	}

	public float checkBalance() {
		return amount;
	}

	public synchronized void deposit(float amt) {
		amount += amt;
	}

	public synchronized void withdraw(float amt) {
		amount -= amt;
	}

}
