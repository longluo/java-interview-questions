package com.longluo.java.interview.interfaces;

public class InterfaceTest implements InterfaceA, InterfaceB {

	public static void main(String[] args) {
		System.out.println(" " + InterfaceA.VAL + "," + InterfaceB.VAL);
	}

	@Override
	public void show() {

	}

	@Override
	public void showB() {
		
	}

	@Override
	public void showA() {
		
	}
}
