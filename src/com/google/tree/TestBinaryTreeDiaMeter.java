package com.google.tree;

public class TestBinaryTreeDiaMeter {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //BinaryTree binaryTree = new BinaryTree(root);
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;

        System.out.println("Original Binary Tree");
        binaryTree.prettyPrintTree(root);

        BinaryTreeDiaMeter binaryTreeDiaMeter = new BinaryTreeDiaMeter();
        System.out.println("Dia " + binaryTreeDiaMeter.diameterOfBinaryTree(root));
    }
}
