package com.udit.linkedlist;

public class CountNodes {

	public static void main(String[] args) {
		
		ListNode<Integer> head = LinkedListUtil.createList(10, 20, 30, 40, 50);
		
		System.out.println("Node count = " + countNodes(head));
	}

	private static int countNodes(ListNode<Integer> head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
