package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class DeleteAllOccurenceOfElement {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(1);
		int val = 1;
		head = removeElements(head, val);
		LinkedListUtil.traverseList(head);
	}

	public static ListNode<Integer> removeElements(ListNode<Integer> head, int val) {
		if (head == null) {
			return head;
		}

		ListNode<Integer> current = head;

		while (current != null && current.next != null) {
			if (current.val == val) {
				current = head = current.next;
			} else if (current.next.val == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		if (head != null && head.val == val && head.next == null) {
			return null;
		}
		return head;
	}
}
