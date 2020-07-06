package com.udit.linkedlist;

public class FindIntersection {

	public static void main(String[] args) {

		ListNode<Integer> list1 = LinkedListUtil.createList(3, 2, 5, 6, 9, 8, 1, 7);

		ListNode<Integer> list2 = new ListNode<Integer>(11);
		list2.next = list1.next.next.next.next.next;
		list2.next.next = null;
		LinkedListUtil.append(list2, 1);
		LinkedListUtil.append(list2, 7);

		System.out.println("List 1 : ");
		LinkedListUtil.traverseList(list1);
		System.out.println("List 2 : ");
		LinkedListUtil.traverseList(list2);

		// Check if tails are not same
		LastNodeDetail d1 = getTailNodeDetail(list1);
		LastNodeDetail d2 = getTailNodeDetail(list2);

		if (d1.node != d2.node) {
			System.out.println("There is no intersection");
		}

		ListNode<Integer> shorter = d1.count < d2.count ? list1 : list2;
		ListNode<Integer> larger = d1.count > d2.count ? list1 : list2;

		larger = moveLarger(larger, Math.abs(d1.count - d2.count));

		while (shorter != larger) {
			shorter = shorter.next;
			larger = larger.next;
		}

		System.out.println("Intersecting Node is " + larger.val);

	}

	private static ListNode<Integer> moveLarger(ListNode<Integer> larger, int k) {
		while (k != 0 && larger != null) {
			larger = larger.next;
			k--;
		}
		return larger;

	}

	private static class LastNodeDetail {

		ListNode<Integer> node;
		int count;

		public LastNodeDetail(ListNode<Integer> node, int count) {
			this.node = node;
			this.count = count;
		}
	}

	private static LastNodeDetail getTailNodeDetail(ListNode<Integer> head) {
		ListNode<Integer> current = head;
		int count = 1;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return new LastNodeDetail(current, count);
	}
}
