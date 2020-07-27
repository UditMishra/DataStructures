package com.udit.bits;

public class ResetLowerSetBit {

	public static void main(String[] args) {
		int x = 5;
		System.out.println(Integer.toBinaryString(x));
		x = x & (x - 1);
		System.out.println(Integer.toBinaryString(x));
	}
}
