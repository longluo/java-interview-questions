package com.longluo.java.interview.exceptions;

import java.text.MessageFormat;

public class MyExceptionTest {

	// throws MyException,抛出我们自定义的MyException类的异常。
	public void regist(int num) throws MyException {
		if (num < 0) {
			// 使用throw手动抛出一个MyException类的异常对象。
			throw new MyException("人数为负值，不合理", 1);
		}
		
		/**
		 * 注意：当我们抛出了异常之后，
		 * System.out.println(MessageFormat.format("登记人数：{0}",num));是不会被执行的。
		 * 抛出异常之后整个方法的调用就结束了。
		 */
		System.out.println(MessageFormat.format("登记人数：{0}", num));
	}

	public void manage() {
		try {
			regist(-100);
		} catch (MyException e) {
			System.out.println("登记失败，错误码：" + e.getId());
			e.printStackTrace();
		}
		System.out.println("操作结束");
	}

	public static void main(String[] args) {
		MyExceptionTest t = new MyExceptionTest();
		t.manage();
	}

}