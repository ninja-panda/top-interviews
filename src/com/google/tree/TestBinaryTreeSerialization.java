package com.google.tree;

public class TestBinaryTreeSerialization {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);


        root.left = b;
        root.right = c;
        c.left = d;
        c.right = e;


        binaryTree.prettyPrintTree(root);
        BinaryTreeSerialization binaryTreeSerialization = new BinaryTreeSerialization();
        String tree = binaryTreeSerialization.serialize(root);
        System.out.println("Serialized Tree > " + tree);

        TreeNode treeNode = binaryTreeSerialization.deserialize(tree);
        System.out.println("Tree after de-serialization");
        binaryTree.prettyPrintTree(treeNode);
    }
}
