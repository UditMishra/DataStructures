package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class PartitionList {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(3, 5, 8, 5, 10, 2, 1);

		int k = 5; // all < 5 at left, all >= 5 at right, 5 can be anywhere in right list

		ListNode<Integer> current = head;

		ListNode<Integer> beforeListStart, beforeListEnd, afterListStart, afterListEnd, next;
		beforeListStart = beforeListEnd = afterListStart = afterListEnd = next = null;

		while (current != null) {
			next = current.next;
			current.next = null;
			if (current.val < k) {
				if (beforeListStart == null) {
					beforeListStart = beforeListEnd = current;
				} else {
					beforeListEnd.next = current;
					beforeListEnd = current;
				}
			} else {
				if (afterListStart == null) {
					afterListStart = afterListEnd = current;
				} else {
					afterListEnd.next = current;
					afterListEnd = current;
				}
			}
			current = next;
		}

		LinkedListUtil.traverseList(beforeListStart);
		LinkedListUtil.traverseList(afterListStart);

		ListNode<Integer> newHead = beforeListStart;

		if (beforeListStart == null) {
			newHead = afterListStart;
		} else if (afterListStart != null) {
			beforeListEnd.next = afterListStart;
		}

		LinkedListUtil.traverseList(newHead);

	}
}
