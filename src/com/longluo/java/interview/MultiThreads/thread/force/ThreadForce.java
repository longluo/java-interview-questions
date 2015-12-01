package com.longluo.java.interview.MultiThreads.thread.force;

public class ThreadForce implements Runnable {

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ThreadForce tf = new ThreadForce();
		Thread demo = new Thread(tf, "线程");

		demo.start();
		for (int i = 0; i < 50; ++i) {
			if (i > 10) {
				try {
					demo.join(); // 强制执行demo
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("main 线程执行-->" + i);
		}
	}
}
