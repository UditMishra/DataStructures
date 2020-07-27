package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {

		ListNode<Integer> head1 = LinkedListUtil.createList(1, 2, 3, 4, 5);
		ListNode<Integer> head2 = LinkedListUtil.createList(1, 2, 3, 4, 5);
		
		LinkedListUtil.traverseList(oddEvenListWay1(head1));
		LinkedListUtil.traverseList(oddEvenListWay2(head2));
	}

	private static ListNode<Integer> oddEvenListWay1(ListNode<Integer> head) {

		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode<Integer> oddHead, evenHead, oddNode, evenNode;
		oddNode = oddHead = head;
		evenNode = evenHead = head.next;

		while (evenNode != null && evenNode.next != null) {
			oddNode.next = evenNode.next;
			evenNode.next = evenNode.next.next;

			oddNode = oddNode.next;
			evenNode = evenNode.next;
		}
		oddNode.next = evenHead;

		return oddHead;
	}

	private static ListNode<Integer> oddEvenListWay2(ListNode<Integer> head) {
		if (head == null) {
			return null;
		}
		ListNode<Integer> prev, current, dang;
		int i = 1;
		prev = dang = null;
		current = head;
		while (current.next != null) {
			prev = current;
			current = current.next;
			if (i == 2) {
				dang = prev;
			}
			prev.next = current.next;
			i++;
		}
		if (i == 2) {
			prev.next = current;
		} else {
			if (i % 2 == 0) {
				prev.next = dang;
			} else {
				current.next = dang;
			}
		}

		return head;
	}
}
