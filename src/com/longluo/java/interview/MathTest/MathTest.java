package com.longluo.java.interview.MathTest;

public class MathTest {
	public static void main(String[] args) {
		System.out.println("小数点后第一位=5");
		System.out.println("正数：Math.round(11.5)=" + Math.round(11.5));
		System.out.println("负数：Math.round(-11.5)=" + Math.round(-11.5));
		System.out.println();

		System.out.println("小数点后第一位<5");
		System.out.println("正数：Math.round(11.46)=" + Math.round(11.46));
		System.out.println("负数：Math.round(-11.46)=" + Math.round(-11.46));
		System.out.println();

		System.out.println("小数点后第一位>5");
		System.out.println("正数：Math.round(11.68)=" + Math.round(11.68));
		System.out.println("负数：Math.round(-11.68)=" + Math.round(-11.68));
	}
}
