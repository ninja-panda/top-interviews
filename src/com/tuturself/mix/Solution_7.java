package com.tuturself.mix;

public class Solution_7 {

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
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int height = matrix.length;
		int width = matrix[0].length;
		int row = height - 1;
		int column = 0;
		while (row >= 0 && column <= width - 1) {
			int elem = matrix[row][column];
			if (elem > target) row--;
			if (elem < target) column++;
			else return true;
		}
		return false;
	}
}
