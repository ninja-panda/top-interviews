package com.google.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSum {

	//Maximum Level Sum of a Binary Tree
	public int maxLevelSum(TreeNode root) {
		if (root == null) return -1;
		Queue<TreeNode> queue = new LinkedList <> ();
		int maxSum = Integer.MIN_VALUE;
		queue.add(root);
		int currentLevel = 1;
		int maxLevel = 0;
		while (!queue.isEmpty()) {
			int no_of_nodes = queue.size();
			int currentSum = 0;
			for (int i = 0; i < no_of_nodes; i++) {
				TreeNode node = queue.remove();
				currentSum = currentSum + node.val;
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			System.out.println("Level:" + currentLevel + " sum is: " + currentSum);
			if (currentSum > maxSum) {
				maxSum = currentSum;
				maxLevel = currentLevel;
			}
			currentLevel++;
		}
		return maxLevel;
	}
}