package com.udit.tree;

import com.udit.util.TreeNode;

public class RangeSumOfTrees {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.left.left = new TreeNode(7);

		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);

		System.out.println(new RangeSumOfTrees().rangeSumBST(root, 3, 6));
	}

	public int rangeSumBST(TreeNode root, int L, int R) {

		int sum = 0; 

		if (root == null) {
			return sum;
		}

		if (root.left != null) {
			sum+= rangeSumBST(root.left, L, R);
		}
		if (root.right != null) {
			sum+= rangeSumBST(root.right, L, R);
		}

		if (root.val >= L && root.val <= R) {
			sum += root.val;
		}

		return sum;
	}
}
