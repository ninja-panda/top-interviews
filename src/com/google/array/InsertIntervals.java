package com.google.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class InsertIntervalsSolution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] in : intervals) {
            Interval interval = new Interval(in[0], in[1]);
            intervalList.add(interval);
        }
        Interval interval = new Interval(newInterval[0], newInterval[1]);
        intervalList.add(interval);
        Collections.sort(intervalList);
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval currentInterval : intervalList) {
            if (merged.isEmpty()) {
                merged.add(currentInterval);
            } else {
                Interval last = merged.getLast();
                if (last.end < currentInterval.start) {
                    merged.add(currentInterval);
                } else {
                    last.end = Math.max(last.end, currentInterval.end);
                }
            }
        }
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            Interval current = merged.get(i);
            result[i][0] = current.start;
            result[i][1] = current.end;
        }
        return result;
    }
}

public class InsertIntervals {
}
