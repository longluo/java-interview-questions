package com.longluo.java.interview.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String args[]) {
		int b = 0;// 使用变量b来装调用read()方法时返回的整数
		FileInputStream in = null;
		
		// 使用FileInputStream流来读取有中文的内容时，读出来的是乱码，因为使用InputStream流里面的read()方法读取内容时是一个字节一个字节地读取的，而一个汉字是占用两个字节的，所以读取出来的汉字无法正确显示。
		// FileReader in =
		// null;//使用FileReader流来读取内容时，中英文都可以正确显示，因为Reader流里面的read()方法是一个字符一个字符地读取的，这样每次读取出来的都是一个完整的汉字，这样就可以正确显示了。
		try {
			in = new FileInputStream(
					"D:\\Java\\MyEclipse 10\\Workspaces\\AnnotationTest\\src\\cn\\galc\\test\\FileInputStream.java");
			// in = new FileReader("D:/java/io/TestFileInputStream.java");
		} catch (FileNotFoundException e) {
			System.out.println("系统找不到指定文件！");
			System.exit(-1);// 系统非正常退出
		}
		
		long num = 0;// 使用变量num来记录读取到的字符数
		try {
			// 调用read()方法时会抛异常，所以需要捕获异常
			while ((b = in.read()) != -1) {
				// 调用int read() throws Exception方法时，返回的是一个int类型的整数
				// 循环结束的条件就是返回一个值-1，表示此时已经读取到文件的末尾了。
				// System.out.print(b+"\t");//如果没有使用“(char)b”进行转换，那么直接打印出来的b就是数字，而不是英文和中文了
				System.out.print((char) b);
				// “char(b)”把使用数字表示的汉字和英文字母转换成字符输入
				num++;
			}
			in.close();// 关闭输入流
			System.out.println();
			System.out.println("总共读取了" + num + "个字节的文件");
		} catch (IOException e1) {
			System.out.println("文件读取错误！");
		}
	}
}
