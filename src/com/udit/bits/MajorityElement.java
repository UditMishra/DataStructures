package com.udit.bits;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2 };
		System.out.println(majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int a : nums) {
			Integer currentCount = countMap.get(a);
			countMap.put(a, currentCount == null ? 1 : currentCount + 1);
		}
		Map.Entry<Integer, Integer> majorityEntry = countMap.entrySet().iterator().next();
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue().compareTo(majorityEntry.getValue()) > 0) {
				majorityEntry = entry;
			}
		}
		return majorityEntry.getKey();
	}
}
