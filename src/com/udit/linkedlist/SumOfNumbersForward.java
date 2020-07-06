package com.udit.linkedlist;

public class SumOfNumbersForward {

	public static void main(String[] args) {

		ListNode<Integer> num1 = LinkedListUtil.createList(9, 9, 5); // 995
		ListNode<Integer> num2 = LinkedListUtil.createList(8, 7, 3, 2); // 8732

		// 995 + 8732 = 9727(Stored as 9->7-->2-->7)

		ListNode<Integer> result = addNodes(num1, num2, 0);

		LinkedListUtil.traverseList(result);

	}

	public static ListNode<Integer> addNodes(ListNode<Integer> node1, ListNode<Integer> node2, int carry) {

		if (node1 == null && node2 == null) {
			return null;
		}

		int sum = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val) + carry;

		ListNode<Integer> resultNode = new ListNode<Integer>(sum % 10);

		ListNode<Integer> n1 = node1 == null ? null : node1.next;
		ListNode<Integer> n2 = node2 == null ? null : node2.next;
		carry = sum > 10 ? 1 : 0;

		resultNode.next = addNodes(n1, n2, carry);

		return resultNode;

	}

}
