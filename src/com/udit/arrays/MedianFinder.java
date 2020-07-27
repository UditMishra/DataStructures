package com.udit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MedianFinder {

	List<Integer> data;

	public MedianFinder() {
		data = new ArrayList<>();
	}

	public void addNum(int num) {
		data.add(num);
		Collections.sort(data);
	}

	public double findMedian() {
		Collections.sort(data);
		double x = 0.0;
		if (data.size() % 2 == 1) {
			x = (double) data.get((int) Math.floor(data.size() / 2));
		} else {
			int i = data.size() == 2 ? 0 : data.size() / 2;
			int a = data.get(i);
			int b = data.get(i == 0 ? i + 1 : i - 1);
			if (a < 0 || b < 0) {
				x = -((Math.abs(a) + Math.abs(b)) / 2.0);

			} else {
				x = (a + b) / 2.0;
			}
			x = (a + b) / 2.0;
		}
		return x;
	}

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(10);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		System.out.println(mf.findMedian());
		mf.addNum(0);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
		
//		mf.addNum(4);
//		mf.addNum(5);
//		mf.addNum(6);
//		mf.addNum(7);
//		System.out.println(mf.findMedian());
	}
}
