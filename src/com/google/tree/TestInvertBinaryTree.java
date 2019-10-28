package com.google.tree;

public class TestInvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(10);

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        e.left = j;

        System.out.println("Original Binary Tree");
        binaryTree.prettyPrintTree(root);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        TreeNode treeNode = invertBinaryTree.recursiveInvert(root);
        System.out.println("Binary Tree after recursive invert");
        binaryTree.prettyPrintTree(treeNode);
    }
}
