package com.longluo.java.interview.CheckBracket;

import java.util.Scanner;

public class CheckBracket {

	public static void main(String[] args) throws Exception {
		System.out.println("Please Input a String:");
		Scanner in = new Scanner(System.in);
		String readLine = in.nextLine();

		String strBrk = findBracket(readLine);
		if (!CheckNumber(strBrk)) {
			System.out.println("括号不正确");
		} else {
			CheckBracketMatch(strBrk);
		}
	}

	// 将字符串中的非字符串剔除
	static String findBracket(String str) {
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == ')') {
				strBuf.append(str.charAt(i));
			}
		}

		return strBuf.toString();
	}

	// 检查字符串中左右括号个个数是否相等
	static boolean CheckNumber(String str) {
		int leftNum = 0;
		int rightNum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				leftNum++;
			}

			if (str.charAt(i) == ')') {
				rightNum++;
			}
		}

		if (leftNum == rightNum) {
			return true;
		} else {
			return false;
		}
	}

	// 检查左右括号是否匹配
	static void CheckBracketMatch(String str) {
		StringBuffer strBuf = new StringBuffer(str);
		int num = str.length() / 2;
		int rightBrk = 0;
		int leftBrk = 0;

		for (int i = 1; i <= num; i++) {
			rightBrk = strBuf.toString().indexOf(')');
			leftBrk = rightBrk - 1;
			
			if (leftBrk >= 0 && strBuf.charAt(leftBrk) == '(') {
				strBuf.deleteCharAt(rightBrk);
				strBuf.deleteCharAt(leftBrk);
			} else {
				System.out.println("括号不正确");
				System.exit(1);
			}
		}

		System.out.println("括号正确");
	}
}
