package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class SwapAdjacentNodes {

	public static void main(String[] args) {

		SwapAdjacentNodes obj = new SwapAdjacentNodes();

		ListNode<Integer> head1 = LinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8);
		ListNode<Integer> head2 = LinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8);

		// 2, 1, 4, 3, 6, 5, 8, 7

		ListNode<Integer> newHead1 = obj.swapPairs1(head1);
		LinkedListUtil.traverseList(newHead1);

		ListNode<Integer> newHead2 = obj.swapPairs2(head2);
		LinkedListUtil.traverseList(newHead2);
	}

	public ListNode<Integer> swapPairs1(ListNode<Integer> head) {
		if ((head == null) || (head.next == null)) {
			return head;
		}
		ListNode<Integer> n = head.next;
		head.next = swapPairs1(head.next.next);
		n.next = head;
		return n;
	}

	public ListNode<Integer> swapPairs2(ListNode<Integer> head) {

		ListNode<Integer> newHead = new ListNode<>(-1);
		
		newHead.next = head;
		
		ListNode<Integer> current = newHead;
		ListNode<Integer> p1 = null, p2 = null;

		while (current.next != null && current.next.next != null) {

			p1 = current.next;
			p2 = current.next.next;
			
			p1.next = p2.next;
			p2.next = p1;
			
			current.next = p2;
			current = p1;
			
		}

		return newHead.next;
	}

}
