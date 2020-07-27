package com.udit.tree;

import java.util.ArrayList;
import java.util.List;

import com.udit.util.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		root.right.right = new TreeNode(6);

		FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
		obj.flatten2(root);
		obj.show(root);
	}

	public void flatten(TreeNode root) {

		List<Integer> data = new ArrayList<>();
		traverse(root, data);

		if (!data.isEmpty()) {
			TreeNode parent = root;
			if (data.size() > 1) {
				for (int i = 1; i < data.size(); i++) {
					TreeNode current = new TreeNode(data.get(i));
					parent.right = current;
					parent.left = null;
					parent = current;
				}
			}
		}
	}

	public void flatten2(TreeNode root) {

		while (root != null) {
			if (root.left != null && root.right != null) {
				TreeNode t = root.left;
				while (t.right != null) {
					t = t.right;
				}
				t.right = root.right;
			}

			if (root.left != null) {
				root.right = root.left;
			}
			root.left = null;
			root = root.right;
		}

	}
	
	public void traverse(TreeNode root, List<Integer> data) {

		if (root == null) {
			return;
		}

		data.add(root.val);

		if (root.left != null) {
			traverse(root.left, data);
		}

		if (root.right != null) {
			traverse(root.right, data);
		}
	}
	public void show(TreeNode root) {

		if (root == null) {
			return;
		}
		
		System.out.println(root.val);
		
		if (root.right != null) {
			show(root.right);
		}
	}
}
