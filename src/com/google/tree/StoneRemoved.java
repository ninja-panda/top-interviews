package com.google.tree;

import java.util.HashSet;
import java.util.Set;

public class StoneRemoved {

	public static int removeStones(int[][] stones) {
		Set<Integer> unique = new HashSet<>();
		int count = 0;
		for (int i = 0; i < stones.length; i++) {
			int x = stones[i][0];
			int y = stones[i][1];
			if (i == 0) {
				unique.add(x);
				unique.add(y);
			} else if (x == y && !unique.add(x)) {
				count++;
			} else {
				boolean isXAdded = unique.add(x);
				boolean isYAdded = unique.add(y);
				if (!isXAdded || !isYAdded) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] stones = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
		System.out.println("Stone Removed " + removeStones(stones));
	}
}
