package com.tuturself.mix;

public class Solution_12 {

	boolean xFound, yFound;
	int levelX = 0;
	int levelY = 0;
	TreeNode parentX = null;
	TreeNode parentY = null;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, x, y, null, 1);
		return (levelX == levelY) && parentX != parentY;
	}

	private void dfs(TreeNode node, int x, int y, TreeNode parent, int depth) {
		if (node == null) return;
		if (xFound && yFound) return;
		if (node.val == x) {
			parentX = parent;
			levelX = depth;
			xFound = true;
		}
		if (node.val == y) {
			parentY = parent;
			levelY = depth;
			yFound = true;
		}
		dfs(node.left, x, y, node, depth + 1);
		dfs(node.right, x, y, node, depth + 1);
	}
}
