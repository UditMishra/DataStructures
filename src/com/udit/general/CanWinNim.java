package com.udit.general;

public class CanWinNim {

	public static void main(String[] args) {

		System.out.println(canWinNim(992832834));
	}

	public static boolean canWinNim(int n) {
		if (n <= 4) {
			return n != 4;
		}

		int t1 = n - 1;
		int t2 = n - 2;
		int t3 = n - 3;

		System.out.println("t1 : " + t1);
		System.out.println("t2 : " + t2);
		System.out.println("t3 : " + t3);

		while (t1 > 4) {
			t1 = t1 % 4;
		}
		while (t2 > 4) {
			t2 = t2 % 4;
		}
		while (t3 > 4) {
			t3 = t3 % 4;
		}

		System.out.println("t1 : " + t1);
		System.out.println("t2 : " + t2);
		System.out.println("t3 : " + t3);

		if (t1 <= 3 || t2 <= 3 || t3 <= 3) {
			return false;
		}
		return true;
	}
}
