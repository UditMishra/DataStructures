package com.udit.tree;

public class LeafSimilarTrees {

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
		
		System.out.println(leafSimilar(root1, root2));;
	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		StringBuffer sb1 = getSequence(root1, new StringBuffer());
		StringBuffer sb2 = getSequence(root2, new StringBuffer());
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		return sb1.toString().equals(sb2.toString());
	}

	public static StringBuffer getSequence(TreeNode root, StringBuffer sb) {

		if (root == null) {
			return sb;
		}

		if (root.left == null && root.right == null) {
			sb.append(root.val);
			return sb;
		}

		return getSequence(root.left, new StringBuffer(sb)).append(getSequence(root.right, new StringBuffer(sb)));
	}
}
