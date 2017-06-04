package com.handx.java.pattern;

public class Main {

	public static void main(String[] args) {

		PersionOne one = new PersionOne();
		one.setAge(10);
		one.setName("小强");
		one.setSex("man");
		System.out.println(one.toString());

		// 这种方式非常的灵活，代码更容易阅读
		PersionTwo two = new PersionTwo.Builder().name("小花").age(10).sex("woman").build();
		System.out.println(two.toString());
	}

}
