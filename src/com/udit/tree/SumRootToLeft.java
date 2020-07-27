package com.udit.tree;

public class SumRootToLeft {

	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(0);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);

		System.out.println("sumRootToLeaf : " + sumRootToLeaf(root));
	}

	public static int sumRootToLeaf(TreeNode root) {
		System.out.println(printPath(root, new StringBuffer()));
		return 0;
	}

	public static int printPath(TreeNode root, StringBuffer sb) {
		if (root == null) {
			return 0;
		}
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			return Integer.valueOf(sb.toString(), 2);
		} else {
			return printPath(root.left, new StringBuffer(sb.toString()))
					+ printPath(root.right, new StringBuffer(sb.toString()));
		}
	}
}
