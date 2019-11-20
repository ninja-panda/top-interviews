package com.google.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {

	public List<List<Integer>> iterativeLevelOrderTraversal(TreeNode root) {
		List <List<Integer>> nodeList = new ArrayList <> ();
		if (root == null) return nodeList;
		Queue <TreeNode> queue = new LinkedList <> ();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			nodeList.add(new ArrayList < > ());
			int no_of_nodes = queue.size();
			for (int i = 0; i < no_of_nodes; i++) {
				TreeNode node = queue.remove();
				nodeList.get(level).add(node.val);
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			level++;
		}
		return nodeList;
	}

	List<List<Integer>> nodeList = new ArrayList <> ();

	public List<List<Integer>> recursiveOrderTraversal(TreeNode root) {
		if (root == null) return nodeList;
		_levelOrder(root, 0);
		return nodeList;
	}

	private void _levelOrder(TreeNode node, int level) {
		if (nodeList.size() == level) {
			nodeList.add(new ArrayList <>());
		}
		nodeList.get(level).add(node.val);
		if (node.left != null) _levelOrder(node.left, (level + 1));
		if (node.right != null) _levelOrder(node.right, (level + 1));
	}
}