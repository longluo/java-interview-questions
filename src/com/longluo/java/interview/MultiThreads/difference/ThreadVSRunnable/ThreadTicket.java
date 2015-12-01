package com.longluo.java.interview.MultiThreads.difference.ThreadVSRunnable;

public class ThreadTicket extends Thread {
	private int tickets = 20;
	
	public ThreadTicket() {
	}
	
	public static void main(String[] args) {
		// 启动了3个线程，分别执行各自的操作
		new ThreadTicket().start();
		new ThreadTicket().start();
		new ThreadTicket().start();
	}

	public void run() {
		while (true) {
			if (tickets > 0) {
				System.out.println(Thread.currentThread().getName() + " Solding Tickets: "
						+ tickets--);
			}
		}
	}

}
