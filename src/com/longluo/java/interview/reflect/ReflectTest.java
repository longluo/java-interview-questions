package com.longluo.java.interview.reflect;

public class ReflectTest {
	public static void main(String[] args) throws Exception {
		/** 第一个例子了解Class类型的定义 */
		String str1 = "abc";// 字符串1
		String str2 = "abcd";// 字符串2
		
		// 三种方式获取Class类型
		Class cls1 = str1.getClass();
		Class cls2 = str2.getClass();
		Class cls3 = String.class;
		Class cls4 = Class.forName("java.lang.String");
		
		System.out.println(cls1);// 打印字符串1类型
		System.out.println(cls2);// 打印字符串2类型
		System.out.println(cls3);
		System.out.println(cls4);
		System.out.println(cls1 == cls2);// 字符串1和字符串2的类型是否相等
		System.out.println(cls1 == cls3);

		// 总之只要在源程序中出现的类型，都有各自的Class实例对象
		System.out.println(cls1.isPrimitive());// 是不是原始类型(同样也有类似的方法判断是不是枚举，数组等类型)
		System.out.println(int.class.isPrimitive());
		System.out.println(int.class == Integer.class);// int类型和Integer类型是不一样的，一个是基本类型，一个是对象类型
		System.out.println(int.class == Integer.TYPE);// 8中数据基本类型都对应与其对象类型中的TYPE字段
		System.out.println(int[].class.isPrimitive());// 数组类型不是原始类型，数组是一个对象类型即int[]是一个Object
	}
}
