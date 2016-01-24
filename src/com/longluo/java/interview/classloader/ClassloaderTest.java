package com.longluo.java.interview.classloader;

import java.util.Date;
import java.util.List;

public class ClassloaderTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// 输出ClassloaderTest的类加载器名称
		System.out.println("ClassloaderTest类的加载器的名称:"
				+ ClassloaderTest.class.getClassLoader().getClass().getName());
		System.out.println("System类的加载器的名称:" + System.class.getClassLoader());
		System.out.println("List类的加载器的名称:" + List.class.getClassLoader());

		ClassLoader cl = ClassloaderTest.class.getClassLoader();
		while (cl != null) {
			System.out.print(cl.getClass().getName() + "->");
			cl = cl.getParent();
		}
		System.out.println(cl);
	}

}
