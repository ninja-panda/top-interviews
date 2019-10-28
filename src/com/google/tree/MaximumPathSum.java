package com.google.tree;

public class MaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;

    private int maximumSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(maximumSum(node.left), 0);
        int rightSum = Math.max(maximumSum(node.right), 0);
        int curSum = node.val + leftSum + rightSum;
        maxSum = Math.max(curSum, maxSum);
        return node.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        maximumSum(root);
        return maxSum;
    }
}
