package com.udit.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	public static void main(String[] args) {

		ListNode<Integer> head = LinkedListUtil.createList(5);

		LinkedListUtil.append(head, 3);
		LinkedListUtil.append(head, 2);
		LinkedListUtil.append(head, head.next);

		// LinkedListUtil.traverseList(head); 
		// can not print due to cycle, it is infinite
		// List = 5 --> 3 --> 2 --> 3 --> 2 --> 3 and so on

		System.out.println(hasCycleWay1(head));
		System.out.println(hasCycleWay2(head));
	}

	public static boolean hasCycleWay1(ListNode<Integer> head) {

		if (head == null) {
			return false;
		}

		ListNode<Integer> current = head;
		Set<ListNode<Integer>> visited = new HashSet<>();

		while (current != null) {

			if (visited.contains(current)) {
				return true;
			}
			visited.add(current);
			current = current.next;
		}

		return false;

	}

	public static boolean hasCycleWay2(ListNode<Integer> head) {

		if (head == null) {
			return false;
		}

		ListNode<Integer> slow, fast;
		slow = fast = head;

		while (fast.next != null && fast.next.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}
}
