package com.longluo.java.interview.Basics.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class IO {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("file.txt"));
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IO Problem!!!");
		}
	}
}
