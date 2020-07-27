package com.udit.tree;

public class SumOfLeftLeafs {

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
		System.out.println(sumOfLeftLeaves(root));
	}
	
	public static int sumOfLeftLeaves(TreeNode root) {
		return leftSum(root, false);
    }
	
	public static int leftSum(TreeNode root, boolean isLeft) {
		int x = 0;
		if(root == null) {		
			return 0;
		}
		if(root.left == null && root.right == null && isLeft) {
			x = root.val;
		}
		return x + leftSum(root.left, true) + leftSum(root.right, false);
	}
}
