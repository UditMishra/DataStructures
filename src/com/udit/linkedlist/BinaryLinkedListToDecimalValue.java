package com.udit.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class BinaryLinkedListToDecimalValue {

	public static void main(String[] args) {
		ListNode<Integer> head = LinkedListUtil.createList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		System.out.println(getDecimalValue(head));
		// Expected : 18800
	}

	private static int getDecimalValue(ListNode<Integer> head) {
		int result = 0;
		List<Integer> list = new ArrayList<>();
		ListNode<Integer> current = head;
		while (current != null) {
			list.add(current.val);
			current = current.next;
		}
		int count = list.size();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 1) {
				double inter = Math.pow(2, count - 1);
				result += inter;
			}
			count--;
		}
		return result;
	}
}
