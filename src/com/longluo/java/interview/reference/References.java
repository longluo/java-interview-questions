package com.longluo.java.interview.reference;

public class References {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Hello");
		StringBuffer sb2 = sb1;
		
		System.out.println("sb1 is:" + sb1);
		
		sb2.append(", World");
		
		System.out.println("sb1 is:" + sb1);
	}

}
