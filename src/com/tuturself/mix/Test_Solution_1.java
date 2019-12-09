package com.tuturself.mix;

public class Test_Solution_1 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		BinaryTree binaryTree = new BinaryTree(root);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(3);


		root.left = b;
		root.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;

		System.out.println("Original Binary Tree");
		binaryTree.prettyPrintTree(root);
		Solution_1 solution_1 = new Solution_1();
		System.out.println(solution_1.pathSum(root,6));
	}
}
