package com.tuturself.mix;

public class Solution_8 {

	int n;
	int[] memo;

	public int climbStairs_1(int n) {
		this.n = n;
		return climb_1(0);
	}

	// O(2^n)
	private int climb_1(int i) {
		if (i > n) return 0;
		if (i == n) return 1;
		return climb_1(i + 1) + climb_1(i + 2);
	}

	// O(n) O(n)
	public int climbStairs_2(int n) {
		this.n = n;
		this.memo = new int[n+1];
		return climb_2(0);
	}

	private int climb_2(int i) {
		if(i > n) return 0;
		if(i == n) return 1;
		if(memo[i] > 0) return memo[i];
		memo[i] = climb_2(i + 1) + climb_2(i + 2);
		return memo[i];
	}

	// O(n) O(n)
	public int climbStairs_3(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 2;
		for(int i =2 ; i < n ; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n-1];
	}

	// O(n) O(1)
	public int climbStairs_4(int n) {
		int first = 1;
		int second = 2;
		int ways = 0;
		for(int i =2 ; i < n ; i++){
			ways = first + second;
			second = first;
			first = ways;
		}
		return ways;
	}
}
