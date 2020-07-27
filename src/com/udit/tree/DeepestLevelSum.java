package com.udit.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.udit.util.TreeNode;

public class DeepestLevelSum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.left.left = new TreeNode(7);

		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);

		System.out.println(deepestLeavesSum(root));
		System.out.println(sumOfDeepestLeaveWay2(root));

	}

	public static int deepestLeavesSum(TreeNode root) {

		int sum = 0, level = 0;
		Stack<Integer> stack = new Stack<>();

		findMaxLevel(root, level, stack);

		int maxLevel = stack.pop();

		sum = sumOfDeepestLeave(root, level, maxLevel);

		return sum;
	}

	public static void findMaxLevel(TreeNode current, int level, Stack<Integer> stack) {

		if (stack.isEmpty()) {
			stack.push(level);
		} else {
			if (level > stack.peek()) {
				stack.pop();
				stack.push(level);
			}
		}

		if (current.left != null) {
			findMaxLevel(current.left, level + 1, stack);
		}

		if (current.right != null) {
			findMaxLevel(current.right, level + 1, stack);
		}

	}

	public static int sumOfDeepestLeave(TreeNode current, int level, int maxLevel) {

		int leftSum = 0, rightSum = 0;
		if (current.left != null) {
			leftSum = sumOfDeepestLeave(current.left, level + 1, maxLevel);
		}

		if (current.right != null) {
			rightSum = sumOfDeepestLeave(current.right, level + 1, maxLevel);
		}

		int sum = leftSum + rightSum;
		if (level == maxLevel) {
			sum += current.val;
		}
		return sum;
	}

	public static int sumOfDeepestLeaveWay2(TreeNode root) {

		int levelSum = 0;

		if (root == null) {
			return levelSum;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			levelSum = 0;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levelSum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}

		}

		return levelSum;

	}


}
