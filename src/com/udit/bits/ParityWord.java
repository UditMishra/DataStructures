package com.udit.bits;

/**
 * Parity of a binary word is 1 if the number of 1s in the word is odd;
 * otherwise 0
 * 
 * @author udmishra
 *
 */
public class ParityWord {

	public static void main(String[] args) {
		int x = 13;
		int count = 0;
		while (x != 0) {
			showDetails(x, count);
			count ^= (x & 1);			
			x >>>= 1;
		}
		System.out.println("Parity : " + (count));
	}

	private static void showDetails(int x, int count) {
		System.out.println(Integer.toBinaryString(x) + " & 1" + " = " + (x & 1));
		System.out.println(count + " ^ " + (x & 1) + " = " + (count ^ (x & 1)));
		System.out.println("----------------------");
	}
	
	/**
	 * Parity for a large number involves
	 * 1. Processing multiple bits at a time
	 * 2. Caching
	 */
}
