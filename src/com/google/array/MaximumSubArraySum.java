package com.google.array;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] arr = {0, -1};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int curSum = 0;
        int maxSum = 0;
        boolean isAllNegative = true;
        int minNegative = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // We found a positive number  or a zero in the array
            if (nums[i] >= 0 && isAllNegative) {
                isAllNegative = false;
            }

            /**
             * Track the minimum negative number in the array
             * when all array numbers are negative
             */
            if (nums[i] < 0 && nums[i] > minNegative && isAllNegative) {
                minNegative = nums[i];
            }

            // adding array elements one by one
            curSum += nums[i];

            // replace currentSum with 0 when it becomes
            // less that 0
            if (curSum < 0) {
                curSum = 0;
            }
            // replace maximum sum when current sum is greater
            // means we have a new sub-array with greater sum
            if (maxSum < curSum) {
                maxSum = curSum;
            }
        }
        return isAllNegative ? minNegative : maxSum;
    }
}
