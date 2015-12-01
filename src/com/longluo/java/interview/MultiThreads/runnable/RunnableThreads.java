package com.longluo.java.interview.MultiThreads.runnable;

public class RunnableThreads {
	
	public static void main(String[] args) {
		RunnableThread rt1 = new RunnableThread("Thread A");
		Thread t1 = new Thread(rt1);
		
		RunnableThread rt2 = new RunnableThread("Thread B");
		Thread t2 = new Thread(rt2);
		
		t1.start();
		t2.start();
	}
}

class RunnableThread implements Runnable {
	private String name = null;
	
	public RunnableThread() {
	}
	
	public RunnableThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  " + i);
		}
	}

}
