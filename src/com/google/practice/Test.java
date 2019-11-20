package com.google.practice;

public class Test {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3,1};
		System.out.println(solution.search(nums, 3));
	}
}

/*{

[1] 1 -> 2 -> 3  -> 4   -> 5
[2] 1 -> 2 -> 3  -> 9   -> 5
[3] 1 -> 2 -> 8  -> 4   -> 5
[4] 1 -> 2 -> 8  -> 9   -> 5
[5] 1 -> 7 -> 3  -> 9   -> 5
[6] 1 -> 7 -> 3  -> 4   -> 5
[7] 1 -> 7 -> 13 -> 9  -> 5
[8] 1 -> 7 -> 8 ->  4  -> 5
[9] 1 -> 7 -> 8 ->  9  -> 5

*/
