package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class SimpleLinkedList {

	public static void main(String[] args) {
		
		ListNode<Integer> head = LinkedListUtil.createList(10, 20, 30, 40, 50);
		
		LinkedListUtil.traverseList(head);
	}	
}
