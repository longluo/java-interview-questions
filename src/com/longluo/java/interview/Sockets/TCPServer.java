package com.longluo.java.interview.Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String args[]) throws IOException {
		ServerSocket serverSock = null;
		PrintWriter out = null;

		try {
			serverSock = new ServerSocket(9999);
		} catch (IOException e) {
			System.err.println("Could not listen on port:9999.");
			System.exit(1);
		}

		Socket clientSock = null;
		try {
			clientSock = serverSock.accept();
		} catch (IOException e) {
			System.err.println("Accept failed!");
			System.exit(1);
		}

		out = new PrintWriter(clientSock.getOutputStream(), true);
		out.println("Hello World!");

		clientSock.close();
		serverSock.close();
	}
}