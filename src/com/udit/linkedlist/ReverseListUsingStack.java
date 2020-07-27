package com.udit.linkedlist;

import java.util.Stack;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class ReverseListUsingStack {

	public static void main(String[] args) {

		ListNode<Integer> list = LinkedListUtil.createList(1, 2, 3);
		ListNode<Integer> rev = reverse(list);
		LinkedListUtil.traverseList(rev);

	}

	public static ListNode<Integer> reverse(ListNode<Integer> list) {

		if (list == null) {
			return null;
		}

		Stack<ListNode<Integer>> stack = new Stack<>();

		while (list != null) {
			stack.push(list);
			list = list.next;
		}

		ListNode<Integer> head = stack.pop();
		ListNode<Integer> current = head;

		while (!stack.isEmpty()) {
			ListNode<Integer> node = stack.pop();
			node.next = null;
			current.next = node;
			current = current.next;
		}

		return head;

	}
}
