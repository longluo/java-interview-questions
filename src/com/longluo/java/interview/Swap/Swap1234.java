package com.longluo.java.interview.Swap;

import java.util.ArrayList;

public class Swap1234 {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for (int i = 1; i < 5; i++) {
			arrayList.add(String.valueOf(i));
		}
		SwapRcr(arrayList, " ");
		
		FourCycle();
	}

	private static void FourCycle() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				for (int k = 1; k < 5; k++) {
					for (int l = 1; l < 5; l++) {
						System.out.println(" " + i + j + k + l);
					}
				}
			}
		}

	}

	private static void SwapRcr(ArrayList<String> array, String prefix) {
		System.out.println(prefix);

		for (int i = 0; i < array.size(); i++) {
			ArrayList<String> temp = new ArrayList<String>(array);
			SwapRcr(temp, prefix + temp.remove(i));
		}
	}
}
