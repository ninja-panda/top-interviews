package com.google.array;

public class RotateArray {

	/**
	 * In place rotation
	 * @param nums
	 * @param k
	 */
	public static void rotate_1(int[] nums, int k) {
		int len = nums.length;
		// If given k in greater than array length
		k = k % len;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * Rotation by temp array
	 * @param nums
	 * @param k
	 */
	public static void rotate_2(int[] nums, int k) {
		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[(i + k) % nums.length] = nums[i];
		}
		// Copy the temp array to the original array
		for (int i = 0; i < nums.length; i++) {
			nums[i] = a[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		System.out.println("In Place Rotation");
		rotate_1(nums,k);
		for (int i : nums) {
			System.out.print(i + ",");
		}
		System.out.println();

		int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
		System.out.println("Rotation by Temp array");
		rotate_2(nums1,k);
		for (int i : nums1) {
			System.out.print(i + ",");
		}
	}
}
