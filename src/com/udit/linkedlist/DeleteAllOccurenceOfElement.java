package com.udit.linkedlist;

import java.util.Arrays;

public class DeleteAllOccurenceOfElement {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(Arrays.asList(3, 11, 8, 3, 10, 2, 3, 11, 3, 9));

		ListNode<Integer> current = head;

		int delete = 3;
		
		if(current.val == delete) {
			head = current.next;
		}

		while (current.next != null) {

			if (current.next.val == delete) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		LinkedListUtil.traverseList(head);
	}
}
