package com.google.array;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


class TreeMapComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return (b - a);
    }
}

class KthLargestSolution {

    public int findKthLargest(int[] nums, int k) {
        TreeMapComparator tc = new TreeMapComparator();
        Map<Integer, Integer> map = new TreeMap<>(tc);
        for (int cur : nums) {
            Integer count = map.get(cur);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(cur, count);
        }
        int i = 0;
        int kthLargest = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            i = i + entry.getValue();
            if (i == k) {
                kthLargest = entry.getKey();
                break;
            } else if (k < i) {
                kthLargest = entry.getKey();
                break;
            }
        }
        return kthLargest;
    }
}


public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {99, 99};
        KthLargestSolution kthLargestSolution = new KthLargestSolution();
        int k = 1;
        int kthLargest = kthLargestSolution.findKthLargest(arr, k);
        System.out.println("k=" + k + " largest element is :" + kthLargest);
    }
}
