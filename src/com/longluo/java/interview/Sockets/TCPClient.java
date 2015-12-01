package com.longluo.java.interview.Sockets;

import java.io.*;
import java.net.*;

public class TCPClient {
	public static void main(String args[]) throws IOException {
		Socket sock = null;
		BufferedReader in = null;

		try {
			sock = new Socket("localhost", 9999);
			in = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host:localhost!");
			System.exit(1);
		}

		catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection.");
			System.exit(1);
		}

		System.out.println(in.readLine());

		in.close();
		sock.close();
	}
}
