package com.longluo.java.interview.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

/**
 * 此类是用来演示如何通过反射获得泛型的实际类型参数 Hibernate中的源代码就有这样的写法
 * 
 */
public class UseReflectGetGenericParameter {
	public static void main(String[] args) throws Exception {
		/**
		 * 通过这种方式得到的字节码中是没有办法得到泛型类的实际类型参数的， 因为在编译这个泛型类时就已经把这个泛型类的实际参数给去掉了
		 * Vector<Date> v = new Vector<Date>(); v.getClass();
		 */
		Method applyMethod = UseReflectGetGenericParameter.class.getMethod(
				"applyVector", Vector.class);
		// 得到泛型类型的参数化类型数组，Type类是Class类的父类
		Type[] types = applyMethod.getGenericParameterTypes();
		/**
		 * ParameterizedType这个类是一个参数化类型类，types数组中存储的都是参数化类型的参数，
		 * 这里取出第一个数组元素，并强制转换成ParameterizedType类型
		 */
		ParameterizedType pType = (ParameterizedType) types[0];
		System.out.println(pType.getRawType()/*
											 * 得到原始类型，输出的结果为：class
											 * java.util.Vector
											 */);
		System.out.println(pType.getActualTypeArguments()[0]/*
															 * 获得泛型的实际类型参数，输出的结果为
															 * ：class
															 * java.util.Date
															 */);
	}

	/**
	 * 利用反射可以得到这个方法的参数列表的类型 通过这个变量v是没有办法知道定义它的那个类型的 但是当把这个变量交给一个方法作为参数或者返回值去使用，
	 * Method类中提供了一系列方法可以获得方法的参数列表 并且是以泛型的那种形式来获得参数列表
	 * 
	 * @param v
	 */
	public static void applyVector(Vector<Date> v) {
	}
}
