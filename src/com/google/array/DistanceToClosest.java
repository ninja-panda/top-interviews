package com.google.array;

import java.util.Arrays;

class SeatingHelper {

    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, len);
        Arrays.fill(right, len);

        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                left[i] = 0;
            } else if (i > 0) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = (len - 1); i >= 0; i--) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else if (i < (len - 1)) {
                right[i] = right[i + 1] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) {
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }
}

public class DistanceToClosest {
    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        SeatingHelper seatingHelper = new SeatingHelper();
        System.out.println("Give a seat after Maximize Distance to Closest Person\n "
                + seatingHelper.maxDistToClosest(seats));
    }
}
