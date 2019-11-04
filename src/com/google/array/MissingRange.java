package com.google.array;

import java.util.ArrayList;
import java.util.List;

class RangeFinder {


    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> rangeList = new ArrayList<>();
        long low = (long) lower;
        long high = (long) upper;
        if (nums == null || nums.length == 0) {
            addRange(low, high, rangeList);
            return rangeList;
        }
        if (low < (long) nums[0]) {
            addRange(low, ((long) nums[0] - 1), rangeList);
        }
        for (int i = 0; i < (nums.length - 1); i++) {
            if ((long) nums[i + 1] - (long) nums[i] > 1) {
                addRange((long) nums[i] + 1, (long) nums[i + 1] - 1, rangeList);
            }
        }
        if (high > nums[nums.length - 1]) {
            addRange(nums[nums.length - 1] + 1, high, rangeList);
        }
        return rangeList;
    }

    private void addRange(long low, long high, List<String> rangeList) {
        if (low == high) {
            rangeList.add(String.valueOf(low));
        } else {
            rangeList.add(String.valueOf(low) + "->" + String.valueOf(high));
        }
    }

}

public class MissingRange {

    public static void main(String[] args) {
        RangeFinder rangeFinder = new RangeFinder();
        int[] nums = {-2147483648, 2147483647};
        List<String> result = rangeFinder.findMissingRanges(nums, -2147483648, 2147483647);
        result.forEach(s -> System.out.println(s));
    }
}
