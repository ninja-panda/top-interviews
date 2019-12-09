package com.tuturself.mix;

public class Solution_6 {

/*
	[
			[1,   4,  7, 11, 15],
			[2,   5,  8, 12, 19],
			[3,   6,  9, 16, 22],
			[10, 13, 14, 17, 24],
			[18, 21, 23, 26, 30]
	]
	*/

	int[][] matrix;

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		this.matrix = matrix;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean found = false;
		for(int i = 0 ; i < m ; i ++){
			found = rowSearch(i,target);
			if(found) break;
		}
		if(!found){
			for(int i = 0 ; i < n ; i ++){
				found = columnSearch(i,target);
				if(found) break;
			}
		}
		return found;
	}

	private boolean rowSearch(int i, int target) {
		int low = 0, high = matrix[0].length - 1;
		while (low <= high){
			int mid = low + (high - low)/2;
			int elem = matrix[i][mid];
			if(elem == target) return true;
			else {
				if(elem > target) high = mid-1;
				else low = mid+1;
			}
		}
		return false;
	}

	private boolean columnSearch(int i, int target) {
		int low = 0, high = matrix.length - 1;
		while (low <= high){
			int mid = low + (high - low)/2;
			int elem = matrix[mid][i];
			if(elem == target) return true;
			else {
				if(elem > target) high = mid-1;
				else low = mid+1;
			}
		}
		return false;
	}
}
