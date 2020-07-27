package com.udit.tree;

public class SameTree {

	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.left.left = null;
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);

		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(9);
		root2.right = new TreeNode(20);
		root2.left.left = null;
		root2.right.left = new TreeNode(15);
		root2.right.right = new TreeNode(7);

		System.out.println(isSameTree(root1, root2));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		StringBuffer sb1 = getAllNodes(p, new StringBuffer());
		StringBuffer sb2 = getAllNodes(q, new StringBuffer());
		if (sb1 == null) {
			if (sb2 == null) {
				return true;
			} else {
				return false;
			}
		} else if (sb2 == null) {
			return false;
		}
		return sb1.toString().equals(sb2.toString());
	}

	public static StringBuffer getAllNodes(TreeNode root, StringBuffer sb) {

		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return sb.append(root.val);
		}
		return sb.append(root.val).append(getAllNodes(root.left, new StringBuffer()))
				.append(getAllNodes(root.right, new StringBuffer()));
	}
}
