package com.tuturself.mix;

public class Solution_10 {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		preOrder(s, sb1, false);
		preOrder(t, sb2, false);
		return sb1.toString().indexOf(sb2.toString()) >= 0;
	}

	private void preOrder(TreeNode node, StringBuilder builder, boolean left) {
		if (node == null) {
			if (left) builder.append("lnull");
			else builder.append("rnull");
			return;
		}
		builder.append("#").append(node.val);
		preOrder(node.left, builder, true);
		preOrder(node.right, builder, false);
	}
}
