package com.google.tree;

public class TestBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(40);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(25);
        TreeNode f = new TreeNode(35);
        TreeNode g = new TreeNode(40);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(25);
        TreeNode j = new TreeNode(35);

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        e.left = j;

        binaryTree.prettyPrintTree(root);
    }
}
