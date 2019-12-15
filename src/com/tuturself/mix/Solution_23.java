package com.tuturself.mix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Maximum Depth of N-ary Tree
 * Iterative solution of the depth of N-ary Tree
 */
public class Solution_23 {

	public int maxDepth(Node root) {
		if (root == null) return 0;
		Queue<Node> nodeQueue = new LinkedList<>();
		Queue<Integer> depthQueue = new LinkedList<>();
		nodeQueue.offer(root);
		depthQueue.offer(1);
		int maxDepth = 0;
		while (!nodeQueue.isEmpty()) {
			Node node = nodeQueue.poll();
			int depth = depthQueue.poll();
			maxDepth = Math.max(maxDepth, depth);
			List<Node> childrens = node.children;
			if (childrens != null && childrens.size() > 0) {
				depth = depth + 1;
				for (Node node1 : childrens) {
					nodeQueue.offer(node1);
				}
				depthQueue.offer(depth);
			}
		}
		return maxDepth;
	}

}
