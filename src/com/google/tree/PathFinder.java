package com.google.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathFinder {

	List<String> paths = null;
	public List<String> binaryTreePathsRecursive(TreeNode root) {
		paths = new ArrayList<>();
		constructPath(root, "");
		return paths;
	}

	private void constructPath(TreeNode node, String path) {
		if (node == null) return;
		path += node.val;
		if (node.left == null && node.right == null) {
			paths.add(path);
		} else {
			path += "->";
			constructPath(node.left, path);
			constructPath(node.right, path);
		}
	}

	public List<String> binaryTreePaths_1(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) return paths;
		LinkedList<TreeNode> nodeStack = new LinkedList<>();
		LinkedList<String> pathStack = new LinkedList<>();
		nodeStack.add(root);
		pathStack.add(String.valueOf(root.val));
		String path = null;
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.removeLast();
			path = pathStack.removeLast();
			if (node.left == null && node.right == null) {
				paths.add(path);
			}
			if (node.left != null) {
				nodeStack.add(node.left);
				pathStack.add(path + "->" + String.valueOf(node.left.val));
			}
			if (node.right != null) {
				nodeStack.add(node.right);
				pathStack.add(path + "->" + String.valueOf(node.right.val));
			}
		}
		return paths;
	}

	public List<String> binaryTreePaths_2(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) return paths;
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<String> pathQueue = new LinkedList<>();
		nodeQueue.add(root);
		pathQueue.add(String.valueOf(root.val));
		String path = null;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			path = pathQueue.poll();
			if (node.left == null && node.right == null) {
				paths.add(path);
			}
			if (node.left != null) {
				nodeQueue.add(node.left);
				pathQueue.add(path + "->" + String.valueOf(node.left.val));
			}
			if (node.right != null) {
				nodeQueue.add(node.right);
				pathQueue.add(path + "->" + String.valueOf(node.right.val));
			}
		}
		return paths;
	}
}
