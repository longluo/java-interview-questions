package com.longluo.java.interview.MultiThreads.threads;

public class HelloThreads extends Thread {
	private String name = null;

	public HelloThreads() {
	}

	public HelloThreads(String name) {
		this.name  = name;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行     " + i);
		}
	}
	
	public static void main(String[] args) {
        HelloThreads ht1 = new HelloThreads("A");
        HelloThreads ht2 = new HelloThreads("B");
        
        /*
         * if we use ht1.run() instead of ht.start(), then the 
         * 
         */
        ht1.start();
        ht2.start();
	}
	
}
