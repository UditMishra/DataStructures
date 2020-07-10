package com.udit.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListInBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.right = new TreeNode(1);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(1);

		root.right.left.left = new TreeNode(9);

		ListNode<Integer> head = LinkedListUtil.createList(1, 10);

		System.out.println(isSubPath(head, root));

	}

	public static boolean isSubPath(ListNode<Integer> head, TreeNode root) {
		if (head == null || root == null) {
			return false;
		}
		String linkedListPath = getLinkedListPath(head);
		if (linkedListPath.length() == 0) {
			return false;
		}
		Set<String> uniquePaths = new HashSet<>();
		findUniquePaths(root, new ArrayList<>(), 1, uniquePaths);
		System.out.println(uniquePaths);

		if (uniquePaths.size() == 0) {
			return false;
		}
		for (String path : uniquePaths) {
			if (path.contains(linkedListPath)) {
				return true;
			}
		}
		return false;
	}

	private static void findUniquePaths(TreeNode root, List<String> list, int level, Set<String> uniquePaths) {

		if (root.left == null && root.right == null) {
			StringBuffer sb = new StringBuffer();
			for (String val : list) {
				sb.append(val);
			}
			sb.append(root.val);
			uniquePaths.add(sb.toString());
		}

		list.add(String.valueOf(root.val));
		if (root.left != null) {
			List<String> newList = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				newList.add(list.get(i));
			}
			list.subList(0, level);
			findUniquePaths(root.left, newList, level + 1, uniquePaths);
		}
		if (root.right != null) {
			List<String> newList = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				newList.add(list.get(i));
			}
			list.subList(0, level);
			findUniquePaths(root.right, newList, level + 1, uniquePaths);
		}
	}

	private static String getLinkedListPath(ListNode<Integer> head) {
		StringBuffer path = new StringBuffer();
		ListNode<Integer> current = head;
		while (current != null) {
			path.append(current.val);
			current = current.next;
		}
		return path.toString();
	}
}
