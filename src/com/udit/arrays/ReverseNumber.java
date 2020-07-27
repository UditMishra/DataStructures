package com.udit.arrays;

public class ReverseNumber {

	public static void main(String[] args) {

		ReverseNumber obj = new ReverseNumber();
		// int num = 1534236469;
		int num = 123;
		System.out.println("Rev : " + obj.reverse(num));
	}

	public int reverse(int x) {
		int rev = 0, prevRev = 0;

		while (x != 0) {
			int d = x % 10;
			rev = rev * 10 + d;
			int a = (rev - d) / 10;
			if (a != prevRev) {
				return 0;
			}
			prevRev = rev;
			x /= 10;
		}
		return rev;
	}

}
