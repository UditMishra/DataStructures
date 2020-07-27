package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class FindMiddleNode {

	public static void main(String[] args) {
		ListNode<Integer> head = LinkedListUtil.createList(1,2,3,4,5,6,7);
		System.out.println(middleNode(head).val);
	}

	private static ListNode<Integer> middleNode(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode<Integer> slow, fast;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
