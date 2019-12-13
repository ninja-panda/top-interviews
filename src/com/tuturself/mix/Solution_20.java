package com.tuturself.mix;

public class Solution_20 {

	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int maxCount = 0;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] == 1){
				count = count + 1;
			}else {
				maxCount = Math.max(maxCount,count);
				count = 0;
			}
		}
		return Math.max(maxCount,count);
	}
}
