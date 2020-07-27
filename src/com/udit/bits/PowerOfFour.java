package com.udit.bits;

public class PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(5));
	}

	public static boolean isPowerOfFour(int num) {
			double k = Math.log(num)/Math.log(4.0);
			System.out.println((k - (int)k) );
			return (k - (int)k) < 0.00000001;
	}
}

// 10000
// 00100
