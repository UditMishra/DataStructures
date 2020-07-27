package com.udit.arrays;

import java.util.ArrayList;
import java.util.List;

public class TestDouble {

	public static void main(String[] args) {
		//int[] arr = { -10, 12, -20, -8, 15 }; //expected true
		//int[] arr = { -16, 3, 8}; // expected false
		int [] arr = {-2,0,10,-19,4,6,-8};
		System.out.println(checkIfExist(arr));
	}

	public static boolean checkIfExist(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		if(arr.length==2 && arr[0]==0 && arr[1]==0) {
			return true;
		}

		List<Integer> list = new ArrayList<>();

		for (int a : arr) {
			list.add(a);
		}

		for (int a : arr) {
			if (a!=0 && list.contains(a * 2)) {
				System.out.println(a);
				return true;
			}
		}
		return false;
	}
}
