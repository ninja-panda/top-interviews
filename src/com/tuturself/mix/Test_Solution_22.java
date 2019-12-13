package com.tuturself.mix;

public class Test_Solution_22 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		BinaryTree binaryTree = new BinaryTree(root);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(3);


		root.left = b;
		root.right = c;

		System.out.println("Original Binary Tree");
		binaryTree.prettyPrintTree(root);
		Solution_22 solution_22 = new Solution_22();
		System.out.println(solution_22.lowestCommonAncestor(root,b,c).val);
	}
}
