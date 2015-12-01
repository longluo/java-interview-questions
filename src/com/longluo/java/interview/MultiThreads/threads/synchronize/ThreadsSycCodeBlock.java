package com.longluo.java.interview.MultiThreads.threads.synchronize;

/**
 * Java线程：线程的同步-同步代码块
 */
public class ThreadsSycCodeBlock {

	public static void main(String[] args) {
		UserDemo u = new UserDemo("张三", 100);
		MineThread t1 = new MineThread("线程A", u, 20);
		MineThread t2 = new MineThread("线程B", u, -60);
		MineThread t3 = new MineThread("线程C", u, -80);
		MineThread t4 = new MineThread("线程D", u, -30);
		MineThread t5 = new MineThread("线程E", u, 32);
		MineThread t6 = new MineThread("线程F", u, 21);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MineThread extends Thread {
	private UserDemo u;
	private int y = 0;

	MineThread(String name, UserDemo u, int y) {
		super(name);
		this.u = u;
		this.y = y;
	}

	public void run() {
		u.oper(y);
	}
}

class UserDemo {
	private String code;
	private int cash;

	UserDemo(String code, int cash) {
		this.code = code;
		this.cash = cash;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 业务方法
	 * 
	 * @param x
	 *            添加x万元
	 */
	public void oper(int x) {
		try {
			Thread.sleep(10L);
			synchronized (this) {
				this.cash += x;
				System.out.println(Thread.currentThread().getName()
						+ "运行结束，增加“" + x + "”，当前用户账户余额为：" + cash);
			}
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "User{" + "code='" + code + '\'' + ", cash=" + cash + '}';
	}
}
