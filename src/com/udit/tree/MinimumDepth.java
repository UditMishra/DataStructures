package com.udit.tree;

public class MinimumDepth {

	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left = null;
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("minDepth : " + minDepth(root));
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int minLeft = minDepth(root.left);
		int minRight = minDepth(root.right);

		System.out.println("Min Left : " + minLeft + ", Min Right : " + minRight);
		if (minLeft == 0) {
			return minRight == 0 ? 1 : minRight + 1;
		} else {
			return minRight == 0 ? minLeft + 1 : Math.min(minLeft, minRight) + 1;
		}
	}
}
