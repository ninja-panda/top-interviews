package com.google.array;


class MountainArraySolution {

    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid + 1] > A[mid]) {
                low = mid + 1;
            }else if(A[mid + 1] < A[mid]){
                high = mid;
            }
        }
        return low;
    }
}

public class MountainArray {
}
