package com.udit.bits;

public class HammingDistance {

	public static void main(String[] args) {

		int x = 1, y = 4, count = 0;

		while ((x > y ? x : y) > 0) {
			System.out.println((x & 1) + ", " + (y & 1));
			count += ((x & 1) ^ (y & 1));
			x >>>= 1;
			y >>>= 1;
		}

		System.out.println(count);
	}
}

//001|0=0 100|0=0
