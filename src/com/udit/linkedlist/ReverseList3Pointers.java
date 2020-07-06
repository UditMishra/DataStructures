package com.udit.linkedlist;

public class ReverseList3Pointers {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(1, 2);

		ListNode<Integer> rev = reverseList(head);

		LinkedListUtil.traverseList(rev);
	}

	private static ListNode<Integer> reverseList(ListNode<Integer> head) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
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
}
