package com.udit.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {

	public static void main(String[] args) {
		SpiralOrderMatrix obj = new SpiralOrderMatrix();
		int[][] mat = { 
				 {1, 2, 3, 4},
				  {5, 6, 7, 8},
				  {9,10,11,12}
					  };

		System.out.println(obj.spiralOrder(mat));
	}

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return list;
		}

		int rowMax = matrix.length;
		int colMax = matrix[0].length;
		
		int rowMin = 0, colMin = 0;

		int count = rowMax * colMax;
		int c = 0;

		int i = 0, j = 0;

		while (c < count) {		
			
			while (j < colMax && c < count) {
				list.add(matrix[i][j++]);
				c++;
			}

			j--;
			i++;
			
			while (i < rowMax && c < count) {
				list.add(matrix[i++][j]);
				c++;
			}

			i--;
			j--;
			
			while (j >= colMin && c < count) {
				list.add(matrix[i][j--]);
				c++;
			}
			
			i--;
			j++;

			while (i > rowMin && c < count) {
				list.add(matrix[i--][j]);
				c++;
			}

			i++;
			j++;
			
			rowMax--;
			colMax--;
			
			rowMin++;
			colMin++;
	 	}

		return list;
	}
}
