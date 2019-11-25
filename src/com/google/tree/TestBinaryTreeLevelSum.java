package com.google.tree;

public class TestBinaryTreeLevelSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		BinaryTree binaryTree = new BinaryTree(root);
		TreeNode node_1 = new TreeNode(9);
		TreeNode node_2 = new TreeNode(8);
		TreeNode node_3 = new TreeNode(30);
		TreeNode node_4 = new TreeNode(15);
		TreeNode node_6 = new TreeNode(-20);
		TreeNode node_7 = new TreeNode(40);
		TreeNode node_8 = new TreeNode(80);

		root.left = node_1;
		root.right = node_2;
		node_1.left = node_3;
		node_1.right = node_4;
		node_2.right = node_6;
		node_4.left = node_7;
		node_4.right = node_8;

		System.out.println("Original Binary Tree");
		binaryTree.prettyPrintTree(root);

		LevelSum levelSum = new LevelSum();
		System.out.println("Level with maximum sum is : " + levelSum.maxLevelSum(root));
	}
}
