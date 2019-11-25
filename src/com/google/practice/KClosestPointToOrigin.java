package com.google.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point point) {
		return ((x * x) + (y * y)) - ((point.x * point.x) + (point.y * point.y));
	}
}

class MaxHeap extends PriorityQueue<Point> {

	public MaxHeap(int size) {
		super(size, new Comparator<Point>() {
			public int compare(Point o1, Point o2) {
				return o2.compareTo(o1);
			}
		});
	}
}

class Solution_2 {
	public int[][] kClosest(int[][] points, int K) {
		MaxHeap maxHeap = new MaxHeap(K);
		for (int[] point : points) {
			Point currentPoint = new Point(point[0], point[1]);
			if (maxHeap.size() < K) {
				maxHeap.add(currentPoint);
			} else {
				Point top = maxHeap.peek();
				if (currentPoint.compareTo(top) < 0) {
					maxHeap.add(currentPoint);
					maxHeap.remove();
				}
			}
		}
		int[][] result = new int[K][2];
		int i = 0;
		for (Point point : maxHeap) {
			result[i][0] = point.x;
			result[i][1] = point.y;
			i++;
		}
		return result;
	}
}

public class KClosestPointToOrigin {
	public static void main(String[] args) {
		int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
		int k = 2;
		Solution_2 solution = new Solution_2();
		int[][] result = solution.kClosest(points, k);
		System.out.println("K Closest points are");
		for (int[] point : result) {
			System.out.println("[x:" + point[0] + ",y:" + point[1] + "]");
		}
	}
}
