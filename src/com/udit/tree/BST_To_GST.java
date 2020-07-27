package com.udit.tree;

import com.udit.util.TreeNode;

public class BST_To_GST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(1);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);

		root.left.right.right = new TreeNode(3);

		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);

		root.right.right.right = new TreeNode(8);

		BST_To_GST obj = new BST_To_GST();
		obj.bstToGst(root);
	}

	public TreeNode bstToGst(TreeNode root) {
		traverse(root);
		sum(root, 0);
		traverse(root);
		return root;
	}

	public void traverse(TreeNode root) {

		if (root.right != null) {
			traverse(root.right);
		}
		System.out.println(root.val);

		if (root.left != null) {
			traverse(root.left);
		}

	}

	public int sum(TreeNode current, int tot) {
		if (current.right != null) {
			tot = sum(current.right, tot);
		}

		tot += current.val;
		current.val = tot;

		if (current.left != null) {
			tot = sum(current.left, tot);
		}

		return tot;
	}

}
