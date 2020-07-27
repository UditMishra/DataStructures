package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class ReverseListBetweenPositions {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(3,4,5);
		int m = 1, n = 2;
		LinkedListUtil.traverseList(reverseBetween(head, m, n));

	}

	public static ListNode<Integer> reverseBetween(ListNode<Integer> head, int m, int n) {

		if (m == n || head == null) {
			return head;
		}
		ListNode<Integer> current, prev, next, endPos, startPos;
		current = prev = next = head;
		startPos = endPos = null;
		int pos = 1;
		while (current != null && current.next != null) {
			if (pos == m) {
				startPos = prev;
				endPos = current;
			}
			if (pos == n) {
				current.next = prev;
				endPos.next = next;
				if (m == 1) {
					return current;
				}
				startPos.next = current;
			}
			if (pos > m && pos < n) {
				current.next = prev;
				if (pos == m + 1) {
					prev.next = null;
				}
				prev = current;
				current = next;
				next = current.next;
			} else {
				prev = current;
				current = current.next;
				next = current.next;
			}
			pos++;

		}
		if (pos == n) {
			if (pos == m + 1) {
				prev.next = null;
			}
			current.next = prev;
			if (m != 1) {
				startPos.next = current;
			} else {
				return current;
			}

		}

		return head;
	}
}
