package com.longluo.java.interview.Toutao;

public class TouTao {
	public static void main(String[] args) {
		Tao(1);
	}
	
	private static int Tao(int day) {
		if(day == 10) {
			return 1;
		} else {
			int num = (Tao(day + 1)*2 + 1);
			System.out.println(num);
			return num;
		}	
	}
}
