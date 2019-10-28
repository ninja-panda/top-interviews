package com.google.array;

public class SubArraySum {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int sum = 3;
        System.out.println(subArraySum(arr, sum));
    }

    public static int subArraySum(int nums[], int k) {

        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int curSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = curSum + nums[i];
            if (curSum == k) {
                curSum = nums[i];
                count++;
            }
            if (curSum > k) {
                curSum = nums[i];
                if (curSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
