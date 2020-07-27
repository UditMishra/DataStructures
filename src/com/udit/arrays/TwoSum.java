package com.udit.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		TwoSum obj = new TwoSum();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] ans = obj.twoSum(nums, target);

		System.out.println("Answer : " + Arrays.toString(ans));
	}

	public int[] twoSum(int[] nums, int target) {

		int[] ans = { -1, -1 };

		Map<Integer, Integer> visited = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int potential = target - nums[i];
			if (visited.containsKey(potential)) {
				ans[0] = visited.get(potential);
				ans[1] = i;
				break;
			} else {
				visited.put(nums[i], i);
			}
		}

		return ans;
	}
}
