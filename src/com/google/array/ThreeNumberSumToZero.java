package com.google.array;

import java.util.*;

public class ThreeNumberSumToZero {

    public static void main(String[] args) {
        int arr[] = {3, -1, -7, -4, -5, 9, 10,-2};
        List<List<Integer>> list = getTriplets(arr);
        System.out.println(list);
    }

    public static List<List<Integer>> getTriplets(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            Set<Integer> search = new HashSet<>();
            for (int j = (i + 1); j < nums.length; j++) {
                int b = nums[j];
                int c = -(a + b);
                if (search.contains(c)) {
                    List<Integer> triplet = Arrays.asList(a, b, c);
                    Collections.sort(triplet);
                    if(!result.contains(triplet)){
                        result.add(triplet);
                    }
                } else {
                    search.add(b);
                }
            }
        }
        return result;
    }
}
