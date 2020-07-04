package com.udit.linkedlist;

import java.util.Arrays;

public class SimpleLinkedList {

	public static void main(String[] args) {
		
		ListNode<Integer> head = LinkedListUtil.createList(Arrays.asList(10, 20, 30, 40, 50));
		
		LinkedListUtil.traverseList(head);
	}	
}
