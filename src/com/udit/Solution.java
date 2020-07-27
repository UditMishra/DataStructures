package com.udit;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
		Solution sol = new Solution();
		// sol.show(mat);
		int[][] res = sol.diagonalSort(mat);
		// sol.show(res);

		// m=3
		// n=4

		// 2,0

		// 1,0
		// 2,1

		// 0,0
		// 1,1
		// 2,2

		// 0,1
		// 1,2
		// 2,3

		// 0,2
		// 1,3

		// 0,3
	}

	public int[][] diagonalSort(int[][] mat) {

		int[][] res = new int[mat.length][mat[0].length];

		System.out.println(mat[2][0] + " ");

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		return res;
	}

	public void show(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
}
