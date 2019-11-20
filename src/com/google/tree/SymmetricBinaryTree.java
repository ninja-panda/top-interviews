package com.google.tree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        List<Integer> before = new ArrayList<>();
        levelOrder(root, before);
        System.out.println("Before Mirroring -> " + before);
        TreeNode node = mirrorTree(root);
        List<Integer> after = new ArrayList<>();
        levelOrder(root, after);
        System.out.println("After Mirroring -> " + after);
        return before.equals(after);
    }

    private TreeNode mirrorTree(TreeNode node) {
        if (node == null){
            return null;
        }
        TreeNode left = mirrorTree(node.left);
        TreeNode right = mirrorTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    private void levelOrder(TreeNode node, List<Integer> nodeValueList) {
        if (node == null) {
            nodeValueList.add(null);
            return;
        }
        nodeValueList.add(node.val);
        levelOrder(node.left, nodeValueList);
        levelOrder(node.right, nodeValueList);
    }
}
