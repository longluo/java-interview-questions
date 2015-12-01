package com.longluo.java.interview.MultiThreads.thread.sleep;

public class ThreadSleep implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + i);
		}
	}

	public static void main(String[] args) {
		ThreadSleep ts = new ThreadSleep();
		Thread demo = new Thread(ts, "线程");
		demo.start();
	}
}
