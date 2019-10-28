package com.google.array;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Boolean> data;
    private int count = 0;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        data = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        Boolean present = data.put(val, true);
        if (present == null) {
            count++;
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set
     * contained the specified element.
     */
    public boolean remove(int val) {
        if (data.containsKey(val)) {
            count--;
            data.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Set<Map.Entry<Integer, Boolean>> entrySet = data.entrySet();
        Random r = new Random();
        int rand = r.nextInt((count - 1) + 1) +1;
        List<Map.Entry<Integer, Boolean>> entryList = new ArrayList<>(entrySet);
        return entryList.get(rand-1).getKey();
    }
}
