package com.google.tree;

import java.util.*;

public class TreeSolution_10 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (p == null) return q;
		if (q == null) return p;

		Map<TreeNode, TreeNode> nodeByParent = new HashMap<>();
		nodeByParent.put(root, null);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current.left != null) {
				nodeByParent.put(current.left, current);
				queue.add(current.left);
			}
			if (current.right != null) {
				nodeByParent.put(current.right, current);
				queue.add(current.right);
			}
		}
		Set<TreeNode> ancestorsOf_P = new HashSet<>();
		while (p != null) {
			ancestorsOf_P.add(p);
			p = nodeByParent.get(p);
		}
		TreeNode commonAncestor = null;
		while (q != null) {
			if (!ancestorsOf_P.contains(q)) {
				ancestorsOf_P.add(q);
				q = nodeByParent.get(q);
			} else {
				commonAncestor = q;
				break;
			}
		}
		return commonAncestor;
	}
}
