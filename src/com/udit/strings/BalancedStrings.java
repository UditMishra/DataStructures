package com.udit.strings;

public class BalancedStrings {

	public static void main(String[] args) {
		String s = "RLRRRLLRLL";
		System.out.println(new BalancedStrings().balancedStringSplit(s));
	}

	public int balancedStringSplit(String s) {

		int c = 0;

		int noOfL = 0;
		int noOfR = 0;

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'L') {
				noOfL++;
			}

			if (s.charAt(i) == 'R') {
				noOfR++;
			}

			if (noOfL == noOfR) {
				c++;
				noOfL = 0;
				noOfR = 0;
			}
		}

		return c;
	}
}
