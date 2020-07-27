package com.udit.tree;

public class TestHeightBalanced {

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
		System.out.println("isBalanced : " + isBalanced(root));
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftHeight = height(root.left);
		int rightheight = height(root.right);
		int height = Math.abs(leftHeight - rightheight);
		return height < 2 && isBalanced(root.left) && isBalanced(root.right);
	}

	public static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
