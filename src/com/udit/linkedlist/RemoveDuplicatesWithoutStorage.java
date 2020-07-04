package com.udit.linkedlist;

import java.util.Arrays;

public class RemoveDuplicatesWithoutStorage {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(Arrays.asList(3, 8, 10, 2, 3, 11, 10, 10, 9, 8, 2, 2, 11));

		ListNode<Integer> outer, inner;
		outer = head;

		while (outer != null) {
			inner = outer.next;
			while (inner != null && inner.next != null) {
				if (inner.next.val == outer.val) {
					inner.next = inner.next.next;
				} else {
					inner = inner.next;
				}
			}
			outer = outer.next;
		}

		LinkedListUtil.traverseList(head);

	}
}
