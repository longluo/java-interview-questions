package com.longluo.java.interview.MultiThreads.difference.ThreadVSRunnable;

public class RunnableTickets {
	
	public static void main(String[] args) {
		RunnableThread rt = new RunnableThread();
		
		// 启动了四个线程，并实现了资源共享的目的
		new Thread(rt).start();
		new Thread(rt).start();
		new Thread(rt).start();
	}
}

class RunnableThread implements Runnable {
	private int tickets = 20;

	public void run() {
		while (true) {
			if (tickets > 0)
				System.out.println(Thread.currentThread().getName() + "出售票"
						+ tickets--);
		}
	}
}
