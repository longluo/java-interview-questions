package com.longluo.java.interview.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

	/**
	 * 任何方法往外抛能处理的异常的时候都有一种简单的写法：“throws Exception”，
	 * 因为Exception类是所有能处理的异常类的根基类，因此抛出Exception类就会抛出所有能够被处理的异常类里了。 使用“throws
	 * Exception”抛出所有能被处理的异常之后，这些被抛出来的异常就是交给JAVA运行时系统处理了，
	 * 而处理的方法是把这些异常的相关错误堆栈信息全部打印出来。
	 * 
	 * @throws Exception
	 */
	void fn() throws Exception {

	}

	/**
	 * 在知道异常的类型以后，方法声明时使用throws把异常往外抛
	 * 
	 * @param i
	 * @throws ArithmeticException
	 */
	void m1(int i) throws ArithmeticException {

	}

	void m2(int i) {
		if (i == 0) {
			// 这种做法就是手动抛出异常，使用“throw+new出来的异常对象”就可以把这个异常对象抛出去了。
			// 这里是new了一个异常对象，在构建这个对象的时候还可以指定他相关的信息，如这里指明了异常信息“i不能等于0”
			// 这个对象抛出去的时候使用getMessage()方法拿到的就是“i不能等于0”这种信息。
			throw new ArithmeticException("i不能等于0");
		}
	}

	/**
	 * 正常情况下如果这里不写try……catch语句那么程序编译时一定会报错，
	 * 因为这里有可能会产生两个个必须要处理的异常：FileNotFoundException和IOException。
	 * 但由于在声明方法f()时已经使用throws把可能产生的这两个异常抛出了， 所以这里可以不写try……catch语句去处理可能会产生的异常。
	 * f()方法把抛出的异常交给下一个要调用它的方法去处理
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	void f() throws FileNotFoundException, IOException {
		// 这里有可能会产生FileNotFoundException异常
		FileInputStream fis = new FileInputStream("MyFile.txt");
		// 这里有可能会产生IOException异常
		int b = fis.read();
		while (b != -1) {
			System.out.println((char) b);
			b = fis.read();
		}
	}

	/**
	 * 在f2()方法里面调用f()方法时必须要处理f()方法抛出来的异常，
	 * 当然，如果f2()方法也没有办法处理f()方法抛出来的异常，那么f2()方法也可以使用throws把异常抛出，
	 * 交给下一个调用了f2()的方法去处理f()方法抛出来的异常。 这里f2()调用f()方法时，选择不处理f()方法中可能抛出的异常，将异常继续抛出
	 * 
	 * @throws Exception
	 */
	void f2() throws Exception {
		f();
	}

	/**
	 * f3方法调用f方法捕获f()方法抛出的2个异常并进行处理
	 */
	void f3() {
		try {
			f();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());// 处理的方法是把错误信息打印出来
		} catch (IOException e) {
			e.printStackTrace();// 处理的方法是使用printStackTrace()方法把错误的堆栈信息全部打印出来。
		}
	}

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
//			fis = new FileInputStream("MyFile.txt");
			fis = new FileInputStream("E://workspace//Java-Interview-Questions//src//com//longluo//java//interview//exceptions//MyFile.txt");
			int b = fis.read();// 这个有可能会抛出IOException异常
			while (b != -1) {
				System.out.println((char) b);
				b = fis.read();
			}
		} catch (FileNotFoundException e) {
			// 使用catch捕获FileNotFoundException类异常的异常对象e。并让异常对象e自己调用printStackTrace方法打印出全部的错误信息
			e.printStackTrace();
		} catch (IOException e) {
			// 再次使用catch捕获IOException类的异常对象e，并让异常对象e自己调用getMessage()方法将错误信息打印出来。
			System.out.println(e.getMessage());
			;
		} finally {
			try {
				/**
				 * 前面已经把一个文件打开了，不管打开这个文件时有没有错误发生，即有没有产生异常，最后都一定要把这个文件关闭掉，
				 * 因此使用了finally语句
				 * ，在finally语句里面不管前面这个文件打开时是否产生异常，在finally这里执行in.close
				 * ()都能把这个文件关闭掉，
				 * 关闭文件也有可能会产生异常，因此在finally里面也使用了try……catch语句去捕获有可能产生的异常。
				 */
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
