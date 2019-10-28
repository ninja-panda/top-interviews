package com.google.tree;

public class TestCompleteBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(40);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(25);
        TreeNode f = new TreeNode(35);

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;

        binaryTree.prettyPrintTree(root);
        CompleteBinaryTree countNodeInCompleteBinaryTree = new CompleteBinaryTree();
        int a = countNodeInCompleteBinaryTree.countNodes(root);
        System.out.println("Total Nodes : " + a);
    }
}
