package com.handx.java.pattern;

/**
 * @ClassName: PersionOne
 * @Description: 使用构建器模式。构建器构建对象的时候，对象的状态是可变的，但是一旦你调用了 build
 *               方法之后，构建的对象就变成了不可变的了。
 * @author handx 908716835@qq.com
 * @date 2017年6月4日 上午11:39:25
 *
 *       注意： 1、 构造方法是私有的，这意味着该类不能从客户端代码直接实例化。 2、字段属性都是final，只能在够着函数上设置值，只有get方法。
 */
public class PersionTwo {

	public static class Builder{
		private String name;
		private String sex;
		private Integer age;

		public Builder age(Integer age) {
			this.age = age;
			return this;
		}

		public PersionTwo build() {
			// 构建方法可以检查这些不变量，如果它们无效，则抛出 IllegalStateException。
			PersionTwo two = new PersionTwo(this);
			if (two.getAge() > 120) {
				throw new IllegalStateException("年龄不能大于120！");
			}
			return two;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder sex(String sex) {
			this.sex = sex;
			return this;
		}

	}


	public final String name;
	public final String sex;
	public final Integer age;

	private PersionTwo(Builder builder) {
		super();
		this.name = builder.name;
		this.sex = builder.sex;
		this.age = builder.age;
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return "PersionTwo [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}

}
