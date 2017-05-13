package com.handx.java.enums;

import java.util.EnumSet;

/**
 * 可以把enum看成一个普通的class，可以定义方法/属性
 * 不同之处是不能使用extends关键字继承其他类，因为enum已经继承了Enum类
 * java单继承
 * 在比较两个枚举类型的值时，不要使用equals，直接使用“==”
 */
public class TestEnum {

	public static void main(String[] args) {
		
		for(EnumSimple e:EnumSimple.values()){
			System.out.println(e.toString());
		}
		System.out.println("====================");
		EnumSimple thu = EnumSimple.THU;
		switch (thu) {
		case MON:
			System.out.println("周一");
			break;
		case TUE:
			System.out.println("周二");
			break;
		case WED:
			System.out.println("周三");
			break;
		case THU:
			System.out.println("周四");
			break;
		case FRI:
			System.out.println("周五");
			break;
		case SAT:
			System.out.println("周六");
			break;
		case SUN:
			System.out.println("周末");
			break;
		default:
			break;
		}
		
		System.out.println("===================");
		System.out.println(EnumSimple.THU.name());//返回此枚举常量名称
		System.out.println(EnumSimple.THU.ordinal());//返回枚举常量的角标，从0开始
		System.out.println(thu.compareTo(EnumSimple.TUE));//比较此枚举与指定枚举对象的顺序
		
		System.out.println("==========enumSet===========");
		EnumSet<EnumSimple> set = EnumSet.allOf(EnumSimple.class);
		for (EnumSimple enumSimple : set) {
			System.out.println(enumSimple);
		}
		
	}

}
