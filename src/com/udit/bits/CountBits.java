package com.udit.bits;

/**
 * Counting the number of bits in a positive integer
 * @author udmishra
 *
 */
public class CountBits {

	public static void main(String[] args) {
		int x = 5;
		int count = 0;
		while (x != 0) {
			System.out.println(Integer.toBinaryString(x) + ", "+(x & 1));
			count += (x & 1); 
			// it does not matter what all bits are, if the last bit is 1 then only 1&1 = 1, else 0
			x >>>= 1;
		}
		System.out.println("Count of 1 : " + count);
	}
}