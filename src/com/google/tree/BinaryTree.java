package com.google.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void prettyPrintTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int[] size = new int[1];
        size[0] = 0;
        int height = height(root, size) - 1;
        int total = 2 * (int) Math.pow(2, height) - 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        for (int i = 0; i <= height; i++) {
            int front = (int) (Math.pow(2, (height - i))) - 1;
            int num = (int) (Math.pow(2, i));
            int interval = num > 1 ? (total - front * 2 - num) / (num - 1) : 0;

            for (int j = 0; j < num; j++) {
                TreeNode peek = queue.poll();

                if (j == 0) {
                    print(front, size, peek);
                } else {
                    print(interval, size, peek);
                }

                if (peek == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(peek.left);
                    queue.offer(peek.right);
                }
            }

            System.out.println();
        }
    }

    private int height(TreeNode root, int[] size) {
        if (root == null) {
            return 0;
        }

        size[0] = Math.max(size[0], Integer.toString(root.val).length());
        return Math.max(height(root.left, size), height(root.right, size)) + 1;
    }

    private void print(int count, int[] size, TreeNode root) {
        for (int i = 0; i < count * size[0]; i++) {
            System.out.print(" ");
        }

        if (root != null) {
            for (int j = 0; j < size[0] - Integer.toString(root.val).length(); j++) {
                System.out.print(" ");
            }

            System.out.print(root.val);
        } else {
            for (int j = 0; j < size[0]; j++) {
                System.out.print(" ");
            }
        }
    }
}
