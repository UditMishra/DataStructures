package com.udit.linkedlist;

import java.util.Arrays;

import com.udit.util.LinkedListUtil;
import com.udit.util.ListNode;

public class NextGreaterNode {

	public static void main(String[] args) {
		ListNode<Integer> head = LinkedListUtil.createList(1, 7, 5, 1, 9, 2, 5, 1);
		int[] result = nextLargerNodes(head);
		System.out.println(Arrays.toString(result));
		// expected: [7,9,9,9,0,5,0,0]
	}

	private static int[] nextLargerNodes(ListNode<Integer> head) {
		if (head == null) {
			return null;
		}
		int[] ele = new int[getCount(head)];
		System.out.println("Count : " + ele.length);
		ListNode<Integer> outer, inner;
		outer = head;
		int i = 0;
		boolean modified = false;
		while (outer != null) {
			modified = false;
			inner = outer.next;
			while (inner != null) {
				if (!modified && inner.val > outer.val) {
					ele[i++] = inner.val;
					modified = true;
				}
				inner = inner.next;
			}
			if (!modified) {
				ele[i++] = 0;
			}
			outer = outer.next;
		}
		return ele;
	}

	private static int getCount(ListNode<Integer> head) {
		ListNode<Integer> current = head;
		int count = 0;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}
}
