package com.udit.linkedlist;

import java.util.List;

public class LinkedListUtil {
	
	public static <T> ListNode<T> createList(List<T> vals) {
		if (vals.isEmpty()) {
			return null;
		}
		ListNode<T> head = new ListNode<>(vals.get(0));
		if (vals.size() == 1) {
			return head;
		}
		ListNode<T> prev = head;
		for (int i = 1; i < vals.size(); i++) {
			ListNode<T> node = new ListNode<>(vals.get(i));
			prev.next = node;
			prev = node;
		}
		return head;
	}

	public static <T> void traverseList(ListNode<T> head) {
		if(head == null) {
			System.out.println("Empty LinkedList");
			return;
		}
		while (head.next != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.print(head.val);
	}
}
