package com.tuturself.mix;

public class Test_Solution_16 {

	public static void main(String[] args) {
		String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 4;
		int[] nums = {6,3,9,1,5,10,4,8,7,2};
		Solution_16 solution_16 = new Solution_16();
		System.out.println(solution_16.topKFrequent(arr,k));
	}
}
