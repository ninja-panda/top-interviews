package com.google.array;

public class TestMergeInterval {

    public static void main(String[] args) {
        int[][] intervals = {{0, 3}, {2, 6}, {8, 10}, {15, 18}, {0, 1}, {3, 7}, {0, 2}};
        MergeInterval mergeInterval = new MergeInterval();
        int[][] result = mergeInterval.merge(intervals);
        print(result);
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0] + "-" + arr[i][1] + " || ");
        }
    }
}
