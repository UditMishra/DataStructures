package com.udit.arrays;

import java.util.Arrays;

public class SortMatrixDiagonally {

	public static void main(String[] args) {

		int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };	
		
		SortMatrixDiagonally obj = new SortMatrixDiagonally();
		obj.show(mat);
		
		int[][] res = obj.diagonalSort(mat);
		obj.show(res);
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
