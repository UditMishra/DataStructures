package com.udit.linkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesWithStorage {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(Arrays.asList(3, 8, 10, 2, 3, 11, 10, 10, 9, 8, 2, 2, 11));

		Set<Integer> visited = new HashSet<>();

		ListNode<Integer> current = head;

		while (current.next != null) {
			if (visited.contains(current.next.val)) {
				current.next = current.next.next;
			} else {
				visited.add(current.next.val);
				current = current.next;
			}
		}

		LinkedListUtil.traverseList(head);

	}
}
