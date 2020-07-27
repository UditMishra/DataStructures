package com.udit.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTester {

	public static void main(String[] args) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		minHeap.add(10);
		minHeap.add(3);
		minHeap.add(5);
		minHeap.add(4);
		minHeap.add(7);

		Integer[] arr = new Integer[minHeap.size()];
		minHeap.toArray(arr);
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (Integer k : minHeap) {
			maxHeap.add(k);
		}

		arr = new Integer[maxHeap.size()];
		maxHeap.toArray(arr);
		Arrays.sort(arr, maxHeap.comparator());
		
		System.out.println(Arrays.toString(arr));

		while (minHeap.size() != 0) {
			System.out.println(minHeap.poll());
		}
		
		while (maxHeap.size() != 0) {
			System.out.println(maxHeap.poll());
		}

	}
}
