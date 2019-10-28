package com.google.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public TreeNode recursiveInvert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = recursiveInvert(root.left);
        TreeNode right = recursiveInvert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode iterativeInvert(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode tempNode = current.left;
            current.left = current.right;
            current.right = tempNode;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }
}
