package com.tuturself.mix;

public class Test_Solution_12 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		BinaryTree binaryTree = new BinaryTree(root);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode e = new TreeNode(4);
		TreeNode g = new TreeNode(5);


		root.left = b;
		root.right = c;
		b.left = e;
		c.right = g;

		System.out.println("Original Binary Tree");
		binaryTree.prettyPrintTree(root);
		Solution_12 solution_1 = new Solution_12();
		System.out.println(solution_1.isCousins(root,4,5));
	}
}
