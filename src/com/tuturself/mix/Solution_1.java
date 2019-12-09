package com.tuturself.mix;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */
public class Solution_1 {

	List<List<Integer>> pathSum = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) return pathSum;
		LinkedList<Integer> path = new LinkedList<>();
		constructPath(path, root, sum, 0);
		return pathSum;
	}

	private void constructPath(LinkedList<Integer> path, TreeNode node, int sum, int curSum) {
		if (node == null) return;
		path.add(node.val);
		curSum += node.val;
		if (node.left == null && node.right == null && sum == curSum) {
			pathSum.add(new ArrayList<>(path));
			int last = path.removeLast();
			curSum = curSum - last;
			return;
		}
		constructPath(path, node.left, sum, curSum);
		constructPath(path, node.right, sum, curSum);
		path.removeLast();
	}
}
