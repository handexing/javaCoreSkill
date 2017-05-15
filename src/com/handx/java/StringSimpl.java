package com.handx.java;

/**
 * 当一个对象实例作为一个参数被传递到方法中时，参数的值就是该对象的引用一个副本。 指向同一个对象,对象的内容可以在被调用的方法中改变，但对象的引用
 * (不是引用的副本)是永远不会改变的。
 * 
 * 如果参数类型是原始类型，那么传过来的就是这个参数的一个副本，也就是这个原始参数的值，这个跟之前所谈的传值是一样的。如果在函数中改变了副本的
 * 值不会改变原始的值.
 * 
 * 如果参数类型是引用类型，那么传过来的就是这个引用参数的副本，这个副本存放的是参数的地址。如果在函数中没有改变这个副本的地址，而是改变了地址中的
 * 值，那么在函数内的改变会影响到传入的参数。如果在函数中改变了副本的地址，如new一个，那么副本就指向了一个新的地址， 此时传入的参数还是指向原来的
 * 地址，所以不会改变参数的值。
 * 
 * @author handx 908716835@qq.com
 * @date 2017年5月15日 下午4:11:49
 */

public class StringSimpl {

	public static void change(String str) {
		str = "xixi";
	}

	public static void changeStudent(Student student) {
		// student = new Student();
		student.setName("rose");
	}

	public static void main(String[] args) {
		String str = "haha";
		change(str);
		System.out.println(str);
		System.out.println("=====================");
		Student student = new Student();
		student.setName("jack");
		changeStudent(student);
		System.out.println(student.getName());
	}

}

class Student {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}