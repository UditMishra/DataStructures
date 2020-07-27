package com.udit.bits;

public class ReverseBits {

	public static void main(String[] args) {

		int n = 43261596;
		int rev = 0;
		for (int i = 0; i < 32; i++) {
			rev <<= 1;
			rev |= (n & 1);
			n >>= 1;
		}
		System.out.println(rev);
	}
}
