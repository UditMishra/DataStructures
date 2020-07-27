package com.udit.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWright {

	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1 };
		System.out.println(lastStoneWeight(stones));
	}

	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int stone : stones) {
			pq.add(stone);
		}
		print(pq);
		while (pq.size() > 1) {
			int y = pq.poll();
			int x = pq.poll();
			System.out.println("x = " + x + ", y = " + y);
			if (x != y) {
				pq.add(y - x);
			}
			System.out.println(pq.size());
			print(pq);
		}
		return pq.size() ==1 ? pq.peek() : 0;
	}

	public static void print(PriorityQueue<Integer> pq) {
		Integer[] arr = new Integer[pq.size()];
		pq.toArray(arr);
		Arrays.sort(arr, pq.comparator());
		System.out.println(Arrays.toString(arr));
	}

}
