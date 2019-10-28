package com.google.tree;

import java.util.ArrayList;
import java.util.List;

class FlipSolution {

    /**
     * Following are the example of 2 flip equivalent Binary Trees.
     * By flipping the left and right child of Tree_2 we can get Tree_1.
     *
     *      (1)            (1)
     *     /  \           /  \
     *   (3) (4)        (4)  (3)
     *
     *   Tree_1         Tree_2
     */

    /**
     * Returns true if both the Binary Tree represented by
     * root1 and root2 are flip equivalent
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> treeOneValueList = new ArrayList<>();
        List<Integer> treeTwoValueList = new ArrayList<>();
        DFS(root1, treeOneValueList);
        DFS(root2, treeTwoValueList);
        System.out.println("Canonical Traversal of Tree 1" + treeOneValueList);
        System.out.println("Canonical Traversal of Tree 2" + treeTwoValueList);
        return treeOneValueList.equals(treeTwoValueList);
    }

    private void DFS(TreeNode node, List<Integer> treeNodeList) {
        if (node != null) {
            treeNodeList.add(node.val);
            int leftChildValue = node.left != null ? node.left.val : -1;
            int rightChildValue = node.right != null ? node.right.val : -1;
            if (leftChildValue < rightChildValue) {
                DFS(node.left, treeNodeList);
                DFS(node.right, treeNodeList);
            } else {
                DFS(node.right, treeNodeList);
                DFS(node.left, treeNodeList);
            }
        }
    }
}

public class FlipEquivalentBinaryTree {

    public static void main(String[] args) {
        TreeNode root_1 = new TreeNode(1);
        BinaryTree binaryTree_1 = new BinaryTree(root_1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);

        root_1.left = b;
        root_1.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        e.left = g;
        e.right = h;

        TreeNode root_2 = new TreeNode(1);
        BinaryTree binaryTree_2 = new BinaryTree(root_2);
        TreeNode b1 = new TreeNode(2);
        TreeNode c1 = new TreeNode(3);
        TreeNode d1 = new TreeNode(4);
        TreeNode e1 = new TreeNode(5);
        TreeNode f1 = new TreeNode(6);
        TreeNode g1 = new TreeNode(7);
        TreeNode h1 = new TreeNode(8);

        root_2.left = c1;
        root_2.right = b1;
        c1.right = f1;
        b1.right = e1;
        b1.left = d1;
        e1.left = g1;
        e1.right = h1;


        System.out.println("Tree 1");
        binaryTree_1.prettyPrintTree(root_1);

        System.out.println("Tree 2");
        binaryTree_2.prettyPrintTree(root_2);

        FlipSolution flipSolution = new FlipSolution();
        System.out.println(flipSolution.flipEquiv(root_1, root_2));
    }
}
