package com.longluo.java.interview.exceptions;

/**
 * 自定义的一个异常类MyException，且是从Exception类继承而来
 */
public class MyException extends Exception {

	private int id;

	/**
	 * 自定义异常类的构造方法
	 * 
	 * @param message
	 * @param id
	 */
	public MyException(String message, int id) {
		super(message); // 调用父类Exception的构造方法
		this.id = id;
	}

	/**
	 * 获取异常的代码
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

}
