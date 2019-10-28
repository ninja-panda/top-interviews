package com.google.array;

public class MissingRange {


    /**
     * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
     * Output: ["2", "4->49", "51->74", "76->99"]
     * <p>
     * [-1] lower = -1 and upper = -1
     * Output: []
     * <p>
     * [-1,0,3]  lower = -3 and upper = 3
     * Output: ["1->2"]
     */
    /*public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(getRange(lower, upper));
        }
        if(lower < nums[0] && nums[0] - lower != 0)

        return null;
    }

    private static String getRange(int lower, int upper) {
        StringBuilder rangeBuilder = new StringBuilder(lower);
        rangeBuilder.append("->").append(upper);
        return rangeBuilder.toString();
    }*/
}
