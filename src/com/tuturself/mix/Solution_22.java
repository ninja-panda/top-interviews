package com.tuturself.mix;

/**
 * 7
 * 4		8
 * 2  5		9
 */
public class Solution_22 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		return findLCA(root, p, q);
	}

	private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode lca = null;
		if (p.val == root.val || q.val == root.val) {
			lca = root;
		}
		if ((p.val < root.val && q.val > root.val) ||
						(q.val < root.val && p.val > root.val)) {
			lca = root;
		}
		if (p.val > root.val && q.val > root.val && root.right != null) {
			lca = findLCA(root.right, p, q);
		}
		if (p.val < root.val && q.val < root.val && root.left != null) {
			lca = findLCA(root.left, p, q);
		}
		return lca;
	}
}
