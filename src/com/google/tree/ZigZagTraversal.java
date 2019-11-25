package com.google.tree;

import java.util.*;

public class ZigZagTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> nodeList = new ArrayList <>();
		if (root == null) return nodeList;
		Queue <TreeNode> queue = new LinkedList <>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int no_of_nodes = queue.size();
			Integer[] placeHolder = new Integer[no_of_nodes];
			boolean even = (level + 1) % 2 == 0 ? true : false;
			int index = 0;
			for (int i = 0; i < no_of_nodes; i++) {
				if (even && i == 0) {
					index = (no_of_nodes - 1);
				}
				TreeNode node = queue.remove();
				placeHolder[index] = node.val;
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
				index = even ? (index - 1) : (index + 1);
			}
			nodeList.add(Arrays.asList(placeHolder));
			level++;
		}
		return nodeList;
	}
}
