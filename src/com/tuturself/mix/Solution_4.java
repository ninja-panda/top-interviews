package com.tuturself.mix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_4 {

	public int maxDepth(TreeNode root) {

		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> depths = new LinkedList<>();
		queue.offer(root);
		depths.offer(1);
		int depth = 0;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int curDepth = depths.poll();
			depth = Math.max(curDepth,depth);
			if(node.left != null){
				queue.offer(node.left);
				depths.offer(curDepth + 1);
			}
			if(node.right != null){
				queue.offer(node.right);
				depths.offer(curDepth + 1);
			}
		}
		return depth;
	}
}
