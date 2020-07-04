package com.udit.linkedlist;

import java.util.Arrays;

public class DeleteAGivenMiddleNode {

	public static void main(String[] args) {
		
		ListNode<Integer> head = LinkedListUtil.createList(Arrays.asList(1, 5, 9, 12));
		
		deleteNode(head.next.next);
		
		LinkedListUtil.traverseList(head);
		
	}
	
	public static void deleteNode(ListNode<Integer> target) {
		
		target.val = target.next.val;
		target.next = target.next.next;
	}
}
