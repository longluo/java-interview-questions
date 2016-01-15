package com.longluo.java.interview.stream;

/*使用FileWriter（字符流）向指定文件中写入数据
写入数据时以1个字符为单位进行写入*/
import java.io.*;

public class FileWriterTest {
	public static void main(String args[]) {
		/*
		 * 使用FileWriter输出流从程序把数据写入到Uicode.dat文件中
		 * 使用FileWriter流向文件写入数据时是一个字符一个字符写入的
		 */
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:/java/Uicode.dat");
			// 字符的本质是一个无符号的16位整数
			// 字符在计算机内部占用2个字节
			// 这里使用for循环把0～60000里面的所有整数都输出
			// 这里相当于是把全世界各个国家的文字都0～60000内的整数的形式来表示
			for (int c = 0; c <= 60000; c++) {
				fw.write(c);
				// 使用write(int c)把0～60000内的整数写入到指定文件内
				// 调用write()方法时，我认为在执行的过程中应该使用了“(char)c”进行强制转换，即把整数转换成字符来显示
				// 因为打开写入数据的文件可以看到，里面显示的数据并不是0～60000内的整数，而是不同国家的文字的表示方式
			}
			/*
			 * 使用FileReader(字符流)读取指定文件里面的内容 读取内容时是以一个字符为单位进行读取的
			 */
			int b = 0;
			long num = 0;
			FileReader fr = null;
			fr = new FileReader("D:/java/Uicode.dat");
			while ((b = fr.read()) != -1) {
				System.out.print((char) b + "\t");
				num++;
			}
			System.out.println();
			System.out.println("总共读取了" + num + "个字符");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
