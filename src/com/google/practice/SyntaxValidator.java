package com.google.practice;

import java.util.*;

public class SyntaxValidator {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] r = twoSum(arr,9);
        System.out.println("arr[0]>" + r[0] + " arr[1]>" + r[1]);
    }

    //Given nums = [2, 7, 11, 15], target = 9, return index
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int diff = target - current;
            Integer index = map.get(current);
            if (index == null) map.put(diff, i);
            else {
                result[0] = i;
                result[1] = index;
                break;
            }
        }
        return result;
    }
}