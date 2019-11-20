package com.google.practice;


class Solution {
    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        // When there is only one element in the array
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int len = (nums.length - 1);
        this.nums = nums;
        this.target = target;
        int rotationPoint = getRotationPoint();
        // When there is no rotation present in the array
        if (rotationPoint == 0) return search(0, len);
        // search in the left side
        if (nums[0] < target) return search(0, rotationPoint);
            // search in the right side
        else return search(rotationPoint, len);
    }

    /**
     * Find the Rotation point of the array. Returns 0
     * if there is no rotation present in the array.
     **/
    private int getRotationPoint() {
        int len = nums.length - 1;
        if (nums[0] < nums[len]) return 0;
        int left = 0, right = len;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[pivot + 1]) return (pivot + 1);
            else if (nums[pivot] > nums[left]) left = (pivot + 1);
            else right = pivot;
        }
        return 0;
    }

    private int search(int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = (mid - 1);
            else left = (mid + 1);
        }
        return -1;
    }
}