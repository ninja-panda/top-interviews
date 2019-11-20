package com.google.array;

import java.util.LinkedList;

class MovingAverage {

    private int size;
    private int currentSum = 0;
    private LinkedList<Integer> data;

    public MovingAverage(int size) {
        this.size = size;
        data = new LinkedList<>();
    }

    public double next(int val) {
        currentSum = currentSum + val;
        data.add(val);
        if (data.size() > size) {
            int first = data.getFirst();
            data.removeFirst();
            currentSum = currentSum - first;
        }
        return currentSum * 1.0 / Math.min(data.size(), size);
    }
}


