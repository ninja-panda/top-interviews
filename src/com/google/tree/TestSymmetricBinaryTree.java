package com.google.tree;

public class TestSymmetricBinaryTree {

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

        SymmetricBinaryTree symmetricBinaryTree = new SymmetricBinaryTree();
        System.out.println("Is Symmetric " + symmetricBinaryTree.isSymmetric(root));
    }
}
