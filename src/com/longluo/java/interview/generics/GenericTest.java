package com.longluo.java.interview.generics;

import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
		/**
		 * 不使用泛型之前ArrayList容器可以存储任意类型的对象
		 */
		ArrayList collection1 = new ArrayList();
		collection1.add(1);// 存储Integer对象
		collection1.add(1L);// 存储Long对象
		collection1.add("xdp");// 存储String对象
		
		/**
		 * 这里会报异常： JAVA.LANG.CLASSCASTEXCEPTION: JAVA.LANG.LONG CANNOT BE CAST
		 * TO JAVA.LANG.INTEGER
		 * 
		 */
//		int i = (Integer) collection1.get(1);
	}
}
