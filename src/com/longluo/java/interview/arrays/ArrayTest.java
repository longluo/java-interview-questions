package com.longluo.java.interview.arrays;

import com.sun.org.apache.xml.internal.security.Init;

public class ArrayTest {

	public static void main(String args[]) {
		int a[]; // 定义数组，即声明一个int类型的数组a[ ]
		a = new int[3]; // 给数组元素分配内存空间。
		a[0] = 3;
		a[1] = 9;
		a[2] = 8; // 给数组元素赋值。
		Date days[];
		days = new Date[3];
		days[0] = new Date(1, 4, 2004);
		days[1] = new Date(2, 4, 2004);
		days[2] = new Date(3, 4, 2004);

		int b[] = { 3, 9, 8 }; // 在定义数组的同时给数组分配空间并赋值。
		Date ds[] = { new Date(1, 4, 2004), new Date(2, 4, 2004),
				new Date(3, 4, 2004) };
		
		int intA[][] = {{1, 2}, {2, 3}, {3, 4, 5}};
		int intB[][] = {{1, 2}, {2, 3}, {4, 5}};
		
	}
}

class Date {
	int year, month, day;

	Date(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
}
