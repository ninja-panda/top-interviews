package com.google.practice;

import java.util.*;

public class Solution {

    /*
       input  = 3  1  2  2  1  3  5
       index =  0  1  2  3  4  5  6
       First Repeat = 3
    */

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 1, 3, 5};
        System.out.println("First Repeat >>" + firstRepeating(arr));

    }

    public static int firstRepeating(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        LinkedHashMap<Integer, Integer> linkedMap = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int count = linkedMap.getOrDefault(cur, 0);
            linkedMap.put(cur, count + 1);
        }
        int firstRepeat = -1;
        Set<Map.Entry<Integer, Integer>> entrySet = linkedMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                firstRepeat = entry.getKey();
                break;
            }
        }
        return firstRepeat;
    }
}

