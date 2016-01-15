package com.longluo.java.interview.stream;

/*这个小程序是重新设置打印输出的窗口，
 * 把默认在命令行窗口输出打印内容设置成其他指定的打印显示窗口
 */
import java.io.*;

public class PrintStreamTest {
	public static void main(String args[]) {
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream("D:/java/log.txt");
			ps = new PrintStream(fos);// 在输出流的外面套接一层打印流，用来控制打印输出
			if (ps != null) {
				System.setOut(ps);// 这里调用setOut()方法改变了输出窗口，以前写System.out.print()默认的输出窗口就是命令行窗口.
				// 但现在使用System.setOut(ps)将打印输出窗口改成了由ps指定的文件里面，通过这样设置以后，打印输出时都会在指定的文件内打印输出
				// 在这里将打印输出窗口设置到了log.txt这个文件里面，所以打印出来的内容会在log.txt这个文件里面看到
			}
			for (char c = 0; c <= 60000; c++) {
				System.out.print(c + "\t");// 把世界各国的文字打印到log.txt这个文件中去
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}