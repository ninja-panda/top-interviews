package com.google.tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalTraversal {

	class LocationOfNode implements Comparable<LocationOfNode> {

		int x, y, val;

		public LocationOfNode(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(LocationOfNode other) {
			if (this.x != other.x) return Integer.compare(this.x, other.x);
			else if (this.y != other.y) return Integer.compare(this.y, other.y);
			else return Integer.compare(this.val, other.val);
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<LocationOfNode> locationOfNodeList = new ArrayList<>();
		dfs(locationOfNodeList, root, 0, 0);
		Collections.sort(locationOfNodeList);
		Map<Integer,List<Integer>> map = new TreeMap<>();
		for(LocationOfNode locationOfNode : locationOfNodeList){
			List<Integer> valueList = map.get(locationOfNode.x);
			if(valueList == null){
				valueList = new ArrayList<>();
				map.put(locationOfNode.x,valueList);
			}
			valueList.add(locationOfNode.val);
		}
		return map.values().stream().collect(Collectors.toList());
	}

	private void dfs(List<LocationOfNode> locationOfNodeList, TreeNode node, int x, int y) {
		if (node == null) return;
		LocationOfNode locationOfNode = new LocationOfNode(x, y, node.val);
		locationOfNodeList.add(locationOfNode);
		dfs(locationOfNodeList, node.left, (x - 1), (y + 1));
		dfs(locationOfNodeList, node.right, (x + 1), (y + 1));
	}
}
