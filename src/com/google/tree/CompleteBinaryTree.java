package com.google.tree;

public class CompleteBinaryTree {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if (lh == rh) {
            int count = (int) Math.pow(2, lh) - 1;
            return count;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
