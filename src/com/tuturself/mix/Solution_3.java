package com.tuturself.mix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_3 {

	public int kthSmallest_Recursive(TreeNode root, int k) {
		List<Integer> inorderList = new ArrayList<>();
		inOrder(root, inorderList);
		if (inorderList != null && !inorderList.isEmpty()) {
			return inorderList.get(k - 1);
		}
		return 0;
	}

	private void inOrder(TreeNode root, List<Integer> inorderList) {
		if (root == null) return;
		inOrder(root.left, inorderList);
		inorderList.add(root.val);
		inOrder(root.right, inorderList);
	}

	public int kthSmallest_Iterative(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while(true){
			while (root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			k = (k-1);
			if (k == 0) return root.val;
			root = root.right;
		}
	}
}
