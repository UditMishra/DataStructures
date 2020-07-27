package com.udit.arrays;

import java.util.Arrays;

public class ShuffleArray {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 1, 3, 4, 7 };
		int n = 3;
		// 2,3,5,4,1,7
		System.out.println(Arrays.toString(shuffle(arr, n)));
	}

	public static int[] shuffle(int[] nums, int n) {

		int[] res = new int[nums.length];
		int k = 0;
		for (int i = 0; i < nums.length / 2; i++) {
			res[k] = nums[i];
			res[k + 1] = nums[i + n];
			k += 2;

		}
		return res;
	}

}
