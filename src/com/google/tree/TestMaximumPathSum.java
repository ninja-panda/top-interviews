package com.google.tree;

public class TestMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-18);
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(11);

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;

        System.out.println("Original Binary Tree");
        binaryTree.prettyPrintTree(root);

        MaximumPathSum maximumPathSum = new MaximumPathSum();
        System.out.println("Maximum Path Sum :" + maximumPathSum.maxPathSum(root));
    }
}
