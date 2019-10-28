package com.google.array;

public class SearchRange {

    public int[] find(int[] nums, int target) {

        int[] targetRange = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        if (targetRange[0] == -1) {
            return targetRange;
        }

        for (int i = nums.length - 1; i >= targetRange[0]; i--) {
            if (nums[i] == target) {
                targetRange[1] = i;
                break;
            }
        }
        return targetRange;
    }
}
