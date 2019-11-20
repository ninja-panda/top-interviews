package com.google.array;

class SearchSolution {

	int[] nums;
	int target;

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		// When the array length is 1, then only the first
		//element can be the target
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		this.nums = nums;
		this.target = target;
		int rotation_index = getRotaionIndex();
		if (rotation_index == 0) return search(0, (nums.length - 1));
		else {
			if (target > nums[0]) return search(0, rotation_index);
			else return search(rotation_index, (nums.length - 1));
		}
	}

	private int getRotaionIndex() {

		// When there is no rotation in the array
		int len = (nums.length - 1);
		if (nums[0] < nums[len]) return 0;
		int left = 0, right = len;
		while (left <= right) {
			int pivot = (left + right) / 2;
			if (nums[pivot] > nums[pivot + 1]) {
				return (pivot + 1);
			} else {
				if (nums[pivot] > nums[left]) left = (pivot + 1);
				else right = pivot;
			}
		}
		return 0;
	}

	private int search(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) return mid;
			if (target < nums[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
}


public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		SearchSolution searchSolution = new SearchSolution();
		int index = searchSolution.search(nums,3);
		System.out.println("Index of 7 :" + index);
	}
}
