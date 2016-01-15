package com.longluo.java.interview.Sockets;

import java.net.*;
import java.io.*;

public class ClientSocketTest {
	public static void main(String args[]) throws Exception {
		/** Client申请连接到Server端上 */
		Socket s = new Socket("127.0.0.1", 6666);

		/**
		 * 连接上服务器端以后，就可以向服务器端输出信息和接收从服务器端返回的信息 输出信息和接收返回信息都要使用流式的输入输出原理进行信息的处理
		 */
		/** 这里是使用输出流OutputStream向服务器端输出信息 */
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		/** 客户端睡眠30秒后再向服务器端发送信息 */
		Thread.sleep(30000);
		dos.writeUTF("Hello Server!");
	}
}
