package com.google.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Interval implements Comparable<Interval> {

    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval interval) {
        if (this.start == interval.start) {
            return this.end - interval.end;
        }
        return this.start - interval.start;
    }

    public String toString() {
        return "[" + start + "-" + end + "]";
    }
}

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            Interval in = new Interval(interval[0], interval[1]);
            intervalList.add(in);
        }
        Collections.sort(intervalList);
        System.out.println("Sorted Intervals" + intervalList);
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalList) {
            if (merged.isEmpty()) {
                merged.add(interval);
            } else {
                Interval lastInterval = merged.getLast();
                if (lastInterval.end < interval.start) {
                    merged.add(interval);
                } else {
                    /*Input: [[1,4],[2,3]]
                    Expected: [[1,4]]*/
                    lastInterval.end = Math.max(merged.getLast().end, interval.end);
                }
            }
        }
        int[][] result = new int[merged.size()][2];
        int i = 0;
        for (Interval interval : merged) {
            result[i][0] = interval.start;
            result[i][1] = interval.end;
            i++;
        }
        return result;
    }
}
