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

    public static List<Integer> getLeaders(int[] nums) {
        List<Integer> leaderList = new ArrayList<>();
        if (nums == null || nums.length == 0) return leaderList;
        int r = (nums.length - 1);
        leaderList.add(nums[r]);
        int currentLeader = nums[r];
        for (int i = r; i >= 0; i--) {
            int cur = nums[i];
            if (cur > currentLeader) {
                currentLeader = cur;
                leaderList.add(currentLeader);
            }
        }
        return leaderList;

    }
}
