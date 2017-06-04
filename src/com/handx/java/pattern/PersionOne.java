package com.handx.java.pattern;

/**
 * @ClassName: PersionOne
 * @Description: 包装数据是最简单的事情之一。 下面是传统的通过定义一个 JavaBean
 *               的实现方式。这种方式既繁琐又浪费代码，即使是使用ide自动生成代码。
 *               说明：http://www.javapractices.com/topic/TopicAction.do?Id=84
 * @author handx 908716835@qq.com
 * @date 2017年6月4日 上午11:39:25
 *
 */
public class PersionOne {

	private String name;
	private String sex;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "PersionOne [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}

}
