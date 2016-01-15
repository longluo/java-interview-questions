package com.longluo.java.interview.stream;

import java.io.*;

public class DataStreamTest {
	public static void main(String args[]) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 在调用构造方法时，首先会在内存里面创建一个ByteArray字节数组
		DataOutputStream dos = new DataOutputStream(baos);
		// 在输出流的外面套上一层数据流，用来处理int，double类型的数
		try {
			dos.writeDouble(Math.random());// 把产生的随机数直接写入到字节数组ByteArray中
			dos.writeBoolean(true);// 布尔类型的数据在内存中就只占一个字节
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			System.out.println(bais.available());
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readDouble());// 先写进去的就先读出来，调用readDouble()方法读取出写入的随机数
			System.out.println(dis.readBoolean());// 后写进去的就后读出来，这里面的读取顺序不能更改位置，否则会打印出不正确的结果
			dos.close();
			bais.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
