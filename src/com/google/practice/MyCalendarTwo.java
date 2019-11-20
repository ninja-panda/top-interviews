package com.google.practice;

import java.util.*;

class MinHeap extends PriorityQueue<Integer> {
    public MinHeap() {
        super(1000, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return (i1 - i2);
            }
        });
    }
}

class TreeMapComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return (i2 - i1);
    }
}

class MyCalendarTwo {

    private MinHeap heap;
    private Map<Integer, Boolean> map;

    public MyCalendarTwo() {
        heap = new MinHeap();
        map = new TreeMap(new TreeMapComparator());
    }

    public boolean book(int start, int end) {
        Integer lastEnd = heap.peek();
        if (lastEnd == null) heap.add(end);
        if (start > lastEnd) {
            heap.add(end);
            map.put(end, true);
        } else if (end <= lastEnd) {
            heap.add(end);
            map.put(end, true);
        } else {
            if (canBook(end)) return true;
            else return false;
        }
        return true;
    }

    private boolean canBook(int end) {
        Set<Integer> set = map.keySet();
        int count = 0;
        for (int i : set) {
            if (i > end) {
                count++;
                if (count > 2) return false;
            }
        }
        return true;
    }
}



