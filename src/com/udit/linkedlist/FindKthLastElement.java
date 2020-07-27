package com.udit.linkedlist;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class FindKthLastElement {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(8, 3, 4, 3, 18, 2, 17, 5, 7, 1, 19);

		int k = 3; // 3rd last element = 7

		ListNode<Integer> slow, fast;

		slow = fast = head;
		int t = k;

		while (fast != null && t > 0) {
			fast = fast.next;
			t--;
		}

		while (fast != null && slow != null) {
			slow = slow.next;
			fast = fast.next;
		}

		System.out.println(k + "th last element is = " + slow.val);

	}
}
