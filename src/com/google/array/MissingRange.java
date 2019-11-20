package com.google.array;

import java.util.ArrayList;
import java.util.List;

class RangeFinder {


    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long low = (long) lower;
        long high = (long) upper;
        List<String> rangeList = new ArrayList<>();
        if (low < nums[0]) rangeList.add(getRange(low, (long) nums[0]-1));
        for (int i = 1; i < nums.length; i++) {
            if ((long) nums[i] - (long) nums[i - 1] > 1) {
                rangeList.add(getRange((long) nums[i - 1] + 1, (long) nums[i] - 1));
            }
        }
        if (high - (long) nums[nums.length - 1] > 1)
            rangeList.add(getRange((long) nums[nums.length - 1] + 1, high));
        return rangeList;
    }

    private String getRange(long low, long high) {
        StringBuffer sb = new StringBuffer();
        if (low == high) sb.append(low);
        else {
            sb.append(low).append("->").append(high);
        }
        return sb.toString();
    }


}

public class MissingRange {

    public static void main(String[] args) {
        RangeFinder rangeFinder = new RangeFinder();
        int[] nums = {-1, 0, 5, 6, 9};
        List<String> result = rangeFinder.findMissingRanges(nums, -2, 12);
        result.forEach(s -> System.out.println(s));
    }
}
