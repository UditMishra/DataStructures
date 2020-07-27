package com.udit.bits;

public class SwapBits {

	public static void main(String[] args) {
		long x = 73;
		System.out.println(Long.toBinaryString(x));
		x = swapBits(x, 1, 5);
		System.out.println(Long.toBinaryString(x));
	}

	public static long swapBits(long x, int i, int j) {
		long bitMask = (1L << i) | (1L << j);
		x ^= bitMask;
		return x;
	}
}
