package com.tuturself.mix;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_15 {

	Map<String, Integer> countByCode;
	List<TreeNode> result;

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		countByCode = new HashMap<>();
		result = new ArrayList<>();
		preOrder(root);
		return result;
	}

	private String preOrder(TreeNode node) {
		if (node == null) return "#";
		String code = node.val + "";
		code += preOrder(node.left);
		code += preOrder(node.right);
		int count = countByCode.getOrDefault(code, 0);
		count = count + 1;
		countByCode.put(code, count);
		if (count == 2) result.add(node);
		return code;
	}
}
