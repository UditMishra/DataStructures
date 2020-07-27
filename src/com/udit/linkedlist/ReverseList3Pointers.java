package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class ReverseList3Pointers {

	public static void main(String[] args) {

		ListNode<Integer> head1 = LinkedListUtil.createList(1, 2);

		ListNode<Integer> rev1 = reverseList1(head1);
		LinkedListUtil.traverseList(rev1);

		ListNode<Integer> head2 = LinkedListUtil.createList(100, 200, 300, 400, 500);

		ListNode<Integer> rev2 = reverseList2(head2);
		LinkedListUtil.traverseList(rev2);
	}

	private static ListNode<Integer> reverseList1(ListNode<Integer> head) {

		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			ListNode<Integer> firstNode = head;
			ListNode<Integer> secondNode = head.next;
			secondNode.next = firstNode;
			firstNode.next = null;
			return secondNode;
		}

		ListNode<Integer> ptr1, ptr2, ptr3;

		ptr1 = head;
		ptr2 = head.next;
		ptr3 = head.next.next;

		ptr1.next = null;

		while (ptr3.next != null) {

			/*
			 * 1 as ptr1 2 as ptr2 3 as ptr3
			 * 
			 * point ptr2 next to ptr1
			 * 
			 * 2 --> 1
			 * 
			 * update ptr1 to ptr2 update ptr2 to ptr3
			 * 
			 * 2 as ptr1 3 as ptr2 4 as ptr3
			 * 
			 * 3 --> 2
			 * 
			 * 3 as ptr1 4 as ptr2 5 as ptr3
			 * 
			 * 
			 */
			ptr2.next = ptr1;
			ptr1 = ptr2;
			ptr2 = ptr3;
			ptr3 = ptr3.next;
		}
		ptr2.next = ptr1;
		ptr3.next = ptr2;

		return ptr3;
	}

	private static ListNode<Integer> reverseList2(ListNode<Integer> head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode<Integer> current, prev, next;
		prev = null;
		current = head;
		next = head.next;

		while (current != null && current.next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = current.next;
		}
		current.next = prev;
		return current;

	}
}
