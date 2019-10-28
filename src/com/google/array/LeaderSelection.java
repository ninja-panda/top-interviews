package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class LeaderSelection {

    public static void main(String[] args) {
        int arr[] = new int[]{10, 34, 5, 15, 9, 2};
        System.out.println("Leaders are >> " + getLeaders(arr));
        int arr1[] = new int[]{10};
        System.out.println("Leaders are >> " + getLeaders(arr1));
        int arr2[] = new int[]{10, 5, 8, 2, 1};
        System.out.println("Leaders are >> " + getLeaders(arr2));
    }

    public static List<Integer> getLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        if (arr == null) {
            return leaders;
        }
        /* Rightmost element is always leader */
        int curLeader = arr[arr.length - 1];
        leaders.add(curLeader);
        for (int i = (arr.length - 1); i >= 0; i--) {
            if (i == (arr.length - 1)) {
                continue;
            }
            if (arr[i] >= curLeader) {
                curLeader = arr[i];
                leaders.add(curLeader);
            }
        }
        return leaders;
    }
}
