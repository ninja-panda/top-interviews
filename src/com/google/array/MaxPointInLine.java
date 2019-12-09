package com.google.array;

import java.util.HashMap;
import java.util.Map;

public class MaxPointInLine {

	public static int maxPoints(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		if (points.length < 3) {
			return points.length;
		}
		Map<Integer, Map<Integer, Integer>> pointCountBySlopeYBySlopeX = new HashMap<>();
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			//Reset map when considering for every point
			pointCountBySlopeYBySlopeX.clear();
			int x_1 = points[i][0];
			int y_1 = points[i][1];

			//Reset overlap and max declaration to 0 when
			// considering for every fresh point
			int max = 0;
			int overlap = 0;
			for (int j = i + 1; j < points.length; j++) {
				int x_2 = points[j][0];
				int y_2 = points[j][1];

				//compute the slope numerator and denominator
				int slope_x = (x_2 - x_1);
				int slope_y = (y_2 - y_1);

				//If both x and y == 0 then both the points in consideration are same.
				// These can be duplicate or overlapping points.So increment overlap
				//and continue the loop since there is no slope for overlapping or
				// duplicate points
				if (slope_x == 0 && slope_y == 0) {
					overlap++;
					continue;
				}
				//Compute the gcd of x and y; so that 2/4 is considered same as 1/2
				int gcd = generateGCD(slope_x, slope_y);
				if (gcd != 0) {
					slope_x = slope_x / gcd;
					slope_y = slope_y / gcd;
				}

				Map<Integer,Integer> pointCountBySlopeY = pointCountBySlopeYBySlopeX.get(slope_x);
				if (pointCountBySlopeY == null) {
					pointCountBySlopeY = new HashMap < > ();
					pointCountBySlopeYBySlopeX.put(slope_x, pointCountBySlopeY);
				}
				Integer count = pointCountBySlopeY.get(slope_y);
				if (count == null) {
					count = 1;
					pointCountBySlopeY.put(slope_y, count);
				} else {
					count = count + 1;
					pointCountBySlopeY.put(slope_y, count);
				}
				//Local max
				max = Math.max(max, count);
			}
			//global maximum
			result = Math.max(max + overlap + 1, result);
		}
		return result;
	}

	private static int generateGCD(int a, int b) {
		if (b == 0) return a;
		else return generateGCD(b, a % b);
	}

	public static void main(String[] args) {
		int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
		System.out.println(maxPoints(points));
	}
}