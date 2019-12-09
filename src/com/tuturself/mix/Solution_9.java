package com.tuturself.mix;

public class Solution_9 {

	public int minCostClimbingStairs(int[] cost) {
		if(cost == null || cost.length == 0) return 0;
		int f1 = cost[0];
		int f2 = cost[1];
		for(int i = 2; i < cost.length ; i++){
			int f3 = cost[i] + Math.min(f1,f2);
			f1 = f2;
			f2 = f3;
		}
		return Math.min(f1,f2);
	}
}
