package com.google.array;

class WaterContainerSolution {

    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = (heights.length - 1);
        while (l < r) {
            int currentArea = Math.min(heights[l], heights[r]) * (r - l);
            maxArea = Math.max(maxArea, currentArea);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}

public class WaterContainer {
    public static void main(String[] args) {
        WaterContainerSolution waterContainerSolution = new WaterContainerSolution();
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("MaxArea " + waterContainerSolution.maxArea(heights));
    }
}
