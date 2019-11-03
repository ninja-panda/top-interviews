package com.google.array;


class MPS {

    // Function to return maximum product of a sub-array of given array
    public int maxProduct(int[] nums)
    {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        // maintain two variables to store maximum and minimum product
        // ending at current index
        int max_ending = 0, min_ending = 0;

        // to store maximum product sub-array found so far
        int max_so_far = 0;

        // traverse the given array
        for (int i: nums)
        {
            int temp = max_ending;

            // update maximum product ending at current index
            max_ending = Integer.max(i, Integer.max(i * max_ending,
                    i * min_ending)
            );

            // update minimum product ending at current index
            min_ending = Integer.min(i, Integer.min(i * temp, i * min_ending));

            max_so_far = Integer.max(max_so_far, max_ending);
        }

        // return maximum product
        return max_so_far;
    }
}

public class MaximumProductSubArray {

    public static void main(String[] args) {

        int[] arr_1 = {3,-1,4};   // Output: 180  // The sub array is {6, -3, -10}
        //int[] arr_2 = {-1, -3, -10, 0, 60}; // Output: 60  // The sub array is {60}
        MPS mps = new MPS();
        System.out.println("Maximum Product in arr_1 :" + mps.maxProduct(arr_1));
        //System.out.println("Maximum Product in arr_2 :" + mps.maxProduct(arr_2));
    }
}
