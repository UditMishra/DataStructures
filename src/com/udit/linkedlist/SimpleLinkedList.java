package com.udit.linkedlist;

public class SimpleLinkedList {

	public static void main(String[] args) {
		
		ListNode<Integer> head = LinkedListUtil.createList(10, 20, 30, 40, 50);
		
		LinkedListUtil.traverseList(head);
	}	
}
