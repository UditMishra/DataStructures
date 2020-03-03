package com.udit.linkedlist;

public class SimpleLinkedList {

	static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = createList();
		traverseList(head);
	}

	private static void traverseList(ListNode head) {
		while (head.next != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.print(head.val);
	}

	private static ListNode createList() {
		ListNode n1 = new ListNode(10);
		ListNode n2 = new ListNode(20);
		ListNode n3 = new ListNode(30);
		ListNode n4 = new ListNode(40);
		ListNode n5 = new ListNode(50);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		return n1;
	}
}
