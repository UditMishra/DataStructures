package com.udit.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class RandomNode {

	private static ListNode<Integer> head = LinkedListUtil.createList(1, 2, 3);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandom());
		}
	}

	private static int getRandom() {
		List<Integer> list = new ArrayList<>();
		ListNode<Integer> current = head;
		while (current != null) {
			list.add(current.val);
			current = current.next;
		}
		int size=list.size();
		Random r = new Random();
		return list.get(r.nextInt(size));
	}
}
