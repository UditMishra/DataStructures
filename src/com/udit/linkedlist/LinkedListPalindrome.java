package com.udit.linkedlist;

import java.util.Stack;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class LinkedListPalindrome {

	public static void main(String[] args) {

		ListNode<Integer> org = LinkedListUtil.createList(1, 2, 3, 2, 1);

		System.out.println("Palindrome : " + isPalindrome(org));
	}

	private static boolean isPalindrome(ListNode<Integer> list) {

		Stack<ListNode<Integer>> stack = new Stack<>();

		ListNode<Integer> current = list;

		int count = 0;
		while (current != null) {
			stack.push(current);
			count++;
			current = current.next;
		}

		int i = 0;

		while (!stack.isEmpty() && i <= count / 2) {
			ListNode<Integer> node = stack.pop();
			if (list.val != node.val) {
				return false;
			}
			list = list.next;
		}

		return true;
	}
}
