package com.google.tree;

public class LCATest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		BinaryTree binaryTree = new BinaryTree(root);
		TreeNode node_1 = new TreeNode(2);
		TreeNode node_2 = new TreeNode(3);
		TreeNode node_3 = new TreeNode(4);
		TreeNode node_4 = new TreeNode(5);
		TreeNode node_5 = new TreeNode(6);
		TreeNode node_6 = new TreeNode(7);
		TreeNode node_7 = new TreeNode(8);
		TreeNode node_8 = new TreeNode(9);

		root.left = node_1;
		root.right = node_2;
		node_1.left = node_3;
		node_1.right = node_4;
		node_2.left = node_5;
		node_2.right = node_6;
		node_3.left = node_7;
		node_3.right = node_8;

		System.out.println("Original Binary Tree");
		binaryTree.prettyPrintTree(root);

		TreeNode p = node_3;
		TreeNode q = node_6;

		// Iterative LCA Finding
		TreeSolution_10 treeSolution10 = new TreeSolution_10();
		TreeNode lca = treeSolution10.lowestCommonAncestor(root, p, q);
		System.out.println("\nIterative Search : LCA of " + p.val + " and " + q.val + " is " + lca.val);

		// Recursive LCA Finding
		TreeSolution_11 treeSolution11 = new TreeSolution_11();
		lca = treeSolution11.lowestCommonAncestor(root, p, q);
		System.out.println("\nRecursive Search : LCA of " + p.val + " and " + q.val + " is " + lca.val);
	}
}
