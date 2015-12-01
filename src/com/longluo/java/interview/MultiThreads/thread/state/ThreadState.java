package com.longluo.java.interview.MultiThreads.thread.state;

public class ThreadState implements Runnable {
	
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
	 
    public static void main(String[] args) {
        ThreadState ts = new ThreadState();
        Thread demo = new Thread(ts);
        
        System.out.println("线程启动之前---》" + demo.isAlive());
        demo.start();
        System.out.println("线程启动之后---》" + demo.isAlive());
    }
}
