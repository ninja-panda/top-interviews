package com.google.array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstRepeatingNumber {

    public static void main(String[] args) {
        int[] arr = {1,3,4,4,6,7,8,2,3};
        System.out.println("First repeating index " + getFirstRepeat(arr));
    }

    public static int getFirstRepeat(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer, Integer> dict = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int count = dict.getOrDefault(cur, 0);
            dict.put(cur, (count + 1));
        }
        int index = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = dict.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                break;
            }
            index++;
        }
        return index;
    }

}
