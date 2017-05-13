package com.handx.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSimple {

	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {

		// 加载类 三种方式
		Class<?> clazz = Class.forName("com.handx.java.reflect.Person");//建议使用这种方式
		System.out.println(new Person().getClass().getName());
		System.out.println(Person.class);

		// 取得全部的构造函数
		Constructor<?> cons[] = clazz.getConstructors();
		Person p1 = (Person) cons[0].newInstance("Rollen");
		System.out.println(p1.toString());

		// 根据参数获取对应的构造函数
		Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
		Person p2 = (Person) constructor.newInstance("jack", 21);//实例化
		System.out.println(p2.toString());

		// 获取内部类私有成员变量和方法
		clazz = Class.forName("com.handx.java.reflect.Person$Child");
		if (clazz != null) {
			Constructor con = clazz.getDeclaredConstructor(Person.class, String.class);
			System.out.println(con.newInstance(new Person(), "man"));

			Method me = clazz.getDeclaredMethod("getName", String.class);
			me.setAccessible(true);
			System.out.println(me.invoke(new Person().new Child(), "handx"));
			
			Field fe = clazz.getDeclaredField("sex");
			fe.setAccessible(true);
			System.out.println(fe.get(new Person().new Child("man")));
		}
		
		//根据实现类获取接口
		clazz = Class.forName("com.handx.java.reflect.MyReflectImpl");
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> c : interfaces) {
			System.out.println("接口："+c.getName());
		}
		//调用类中的方法
		Method method = clazz.getMethod("sayHello",String.class);
		method.invoke(clazz.newInstance(), "handx");
		//获取父类
		System.out.println("父类："+clazz.getSuperclass().getName());
	
		
	}

}
