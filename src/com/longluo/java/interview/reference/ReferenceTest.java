package com.longluo.java.interview.reference;

class A {
	int a = 1;
	char b = 'A';

	public A() {
	}

	public A(int _a, char _b) {
		this.a = _a;
		this.b = _b;
	}

	public String toString() {
		return "a=" + this.a + ",b=" + this.b;
	}
}

public class ReferenceTest {
	public static A changeA(A classa) {
		classa.a = 2;
		classa.b = 'B';
		return classa;
	}

	public static String changeString(String str) {
		System.out.println(str.hashCode());
		str = str.toLowerCase();
		System.out.println(str.hashCode());
		return str;
	}

	public static int changeint(int a) {
		a = a + 1;
		return a;
	}

	public static Integer changeInteger(Integer a) {
		a = new Integer(9);
		return a;
	}

	public static int[] changeintarray(int a[]) {
		a[0] = 10;
		return a;
	}

	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 自定义的对象传递的是引用
		A a = new A();
		A b = changeA(a);
		System.out.println(a);
		System.out.println(b);
		System.out.println("----------------------");
		// String对象作为参数传递的也是引用(只是String对象的值不能变,每一个修改String对象的值都会重新创建一个新的String对象用以保存修改后的值，原来的值不会变)
		String str1 = "HUHUALIANG";
		System.out.println(str1.hashCode());
		String str2 = changeString(str1);
		System.out.println(str2.hashCode());
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("----------------------");
		// 基本类型是值传递
		int inta = 8;
		int intb = changeint(inta);
		System.out.println(inta);
		System.out.println(intb);
		System.out.println("----------------------");
		// 基本类型的包装集作为参数传递的是值而不是引用
		Integer c = new Integer(1);
		Integer d = changeInteger(c);
		System.out.println(c);
		System.out.println(d);
		System.out.println("----------------------");
		// 数组传递的是引用
		int[] arraya = { 0, 1, 2, 3 };
		int[] arrayb = changeintarray(arraya);
		printArray(arraya);
		printArray(arrayb);
	}
}
