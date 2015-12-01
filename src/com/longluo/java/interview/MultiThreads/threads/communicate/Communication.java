package com.longluo.java.interview.MultiThreads.threads.communicate;

class ShareData {
	private char c;
	private boolean isProduced = false; // 信号量

	// 同步方法putShareChar()
	public synchronized void putShareChar(char c) {
		// 如果产品还未消费，则生产者等待
		if (isProduced) {
			try {
				wait(); // 生产者等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.c = c;
		isProduced = true; // 标记已经生产
		notify(); // 通知消费者已经生产，可以消费
	}

	// 同步方法getShareChar()
	public synchronized char getShareChar() {
		// 如果产品还未生产，则消费者等待
		if (!isProduced) {
			try {
				wait(); // 消费者等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		isProduced = false; // 标记已经消费
		notify(); // 通知需要生产
		return this.c;
	}
}

// 生产者线程
class Producer extends Thread {
	private ShareData s;

	Producer(ShareData s) {
		this.s = s;
	}

	public void run() {
		for (char ch = 'A'; ch <= 'D'; ch++) {
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			s.putShareChar(ch); // 将产品放入仓库
			System.out.println(ch + " is produced by Producer.");
		}
	}
}

// 消费者线程
class Consumer extends Thread {
	private ShareData s;

	Consumer(ShareData s) {
		this.s = s;
	}

	public void run() {
		char ch;

		do {
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ch = s.getShareChar(); // 从仓库中取出产品
			System.out.println(ch + " is consumed by Consumer. ");
		} while (ch != 'D');
	}
}

public class Communication {
	public static void main(String[] args) {
		ShareData s = new ShareData();
		new Consumer(s).start();
		new Producer(s).start();
	}
}
