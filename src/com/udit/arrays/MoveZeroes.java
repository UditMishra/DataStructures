package com.udit.arrays;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		
		MoveZeroes obj = new MoveZeroes();
		int[] n = { 0,1,-1,0,21,22,3,0,0,0,2,0 };
		obj.moveZeroes(n);
	}
	
	public void moveZeroes(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}

		int size = nums.length;
		int lastNonZeroIndex = 0;
		for (int i = 0; i < size; i++) {
			if (nums[i] != 0) {
				nums[lastNonZeroIndex++] = nums[i];
			}
		}
		for(int i=lastNonZeroIndex;i<size;i++) {
			nums[i] = 0;
		}

		System.out.println("Final : "+Arrays.toString(nums));
	}
}
