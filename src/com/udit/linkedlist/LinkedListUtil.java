package com.udit.linkedlist;

public class LinkedListUtil {

	@SafeVarargs
	public static <T> ListNode<T> createList(T... vals) {
		if (vals == null || vals.length == 0) {
			return null;
		}
		ListNode<T> head = new ListNode<>(vals[0]);
		if (vals.length == 1) {
			return head;
		}
		ListNode<T> prev = head;	
		for (int i = 1; i < vals.length; i++) {
			ListNode<T> node = new ListNode<>(vals[i]);
			prev.next = node;
			prev = node;
		}
		return head;
	}

	public static <T> void append(ListNode<T> head, T val) {
		ListNode<T> node = new ListNode<>(val);
		ListNode<T> current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	public static <T> void append(ListNode<T> head, ListNode<T> node) {
		
		ListNode<T> current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;	
	}

	public static <T> void traverseList(ListNode<T> head) {
		if (head == null) {
			System.out.println("Empty LinkedList");
			return;
		}
		while (head.next != null) {
			System.out.print(head.val + " --> ");
			head = head.next;
		}
		System.out.print(head.val);
		System.out.println();
	}
}
