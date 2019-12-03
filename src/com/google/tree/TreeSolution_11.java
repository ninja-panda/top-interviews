package com.google.tree;

public class TreeSolution_11 {

	private TreeNode commonAncestor;


	private boolean recursiveFind(TreeNode currentNode, TreeNode p, TreeNode q) {

		// If reached the end of a branch, return false.
		if (currentNode == null) {
			return false;
		}

		// If p or q is present in left subtree returns true
		// set left = 1 else 0
		int left = this.recursiveFind(currentNode.left, p, q) ? 1 : 0;

		// If p or q is present in right subtree returns true
		// set left = 1 else 0
		int right = this.recursiveFind(currentNode.right, p, q) ? 1 : 0;

		// If the current node is one of p or q
		int mid = (currentNode == p || currentNode == q) ? 1 : 0;


		// If any two of the flags left, right or mid become True
		if (mid + left + right >= 2) {
			this.commonAncestor = currentNode;
		}

		// Return true if any one of the three bool values is True.
		return (mid + left + right > 0);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Traverse the tree and find the LCA recursively
		this.recursiveFind(root, p, q);
		return this.commonAncestor;
	}
}
