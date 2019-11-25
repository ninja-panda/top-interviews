package com.google.array;

import java.util.*;

class Point implements Comparable < Point > {
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

class KClosestPointToOriginSol {
    public int[][] kClosest(int[][] points, int K) {
        List<Point> pointList = new ArrayList <>();
        for (int[] point: points) {
            Point p = new Point(point[0], point[1]);
            pointList.add(p);
        }
        Collections.sort(pointList);
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point point = pointList.get(i);
            ans[i][0] = point.x;
            ans[i][1] = point.y;
        }
        return ans;
    }
}

public class KClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        KClosestPointToOriginSol solution = new KClosestPointToOriginSol();
        int[][] result = solution.kClosest(points, k);
        System.out.println("K Closest points are");
        for (int[] point: result) {
            System.out.println("[x:" + point[0] + ",y:" + point[1] + "]");
        }
    }
}