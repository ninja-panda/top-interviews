package com.google.tree;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode node = (TreeNode) o;
        return val == node.val;
    }

    @Override
    public int hashCode() {
        return val;
    }
}
