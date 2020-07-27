package com.udit.chars;

import java.util.Arrays;

public class ShortestDistanceToChar {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
	}

	public static int[] shortestToChar(String S, char C) {
		int[] arr = new int[S.length()];

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (ch == C) {
				arr[i] = 0;
				continue;
			}

			int leftCount = 0, rightCount = 0;

			for (int j = i - 1, counter = 0; j >= 0; j--, counter++) {
				if (S.charAt(j) == C) {
					leftCount = counter + 1;
					break;
				}
			}
			for (int j = i + 1, counter = 0; j < S.length(); j++, counter++) {
				if (S.charAt(j) == C) {
					rightCount = counter + 1;
					break;
				}
			}

			arr[i] = leftCount == 0 ? rightCount
					: (rightCount == 0 ? leftCount : (leftCount < rightCount ? leftCount : rightCount));
		}
		return arr;
	}
}
