package com.google.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeSerialization {

    // Encodes a tree to a single String.
    public String serialize(TreeNode root) {
        StringBuilder treeBuilder = new StringBuilder();
        preOrder(root, treeBuilder);
        return treeBuilder.toString();
    }

    private void preOrder(TreeNode treeNode, StringBuilder treeBuilder) {
        if (treeNode == null) {
            treeBuilder.append("null,");
            return;
        }
        treeBuilder.append(treeNode.val + ",");
        preOrder(treeNode.left, treeBuilder);
        preOrder(treeNode.right, treeBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(tree));
        return constructBinaryTree(linkedList);
    }

    private TreeNode constructBinaryTree(LinkedList<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = constructBinaryTree(l);
        root.right = constructBinaryTree(l);
        return root;
    }
}
