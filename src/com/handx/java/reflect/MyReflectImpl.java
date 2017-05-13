package com.handx.java.reflect;

public class MyReflectImpl implements MyReflectDao {

	@Override
	public void sayHello(String name) {
		System.out.println("hello----:" + name);
	}

}
