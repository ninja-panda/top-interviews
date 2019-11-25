package com.google.practice;

class UniquePathIISolution {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		// If the starting cell has an obstacle, then simply return
		// as there would be no paths to the destination.
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;

		// Filling the values for the first column
		boolean obstacleFound = false;
		for (int i = 0; i < rows; i++) {
			if (obstacleGrid[i][0] == 0 && !obstacleFound) {
				obstacleGrid[i][0] = 1;
			} else {
				obstacleGrid[i][0] = 0;
				obstacleFound = true;
			}
		}

		// Filling the values for the first row
		obstacleFound = false;
		for (int i = 1; i < columns; i++) {
			if (obstacleGrid[0][i] == 0 && !obstacleFound) {
				obstacleGrid[0][i] = 1;
			} else {
				obstacleGrid[0][i] = 0;
				obstacleFound = true;
			}
		}

		// Starting from cell(1,1) fill up the values
		// No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
		// i.e. From above and left.
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (obstacleGrid[i][j] == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}
		// Return value stored in rightmost bottommost cell. That is the destination.
		return obstacleGrid[rows - 1][columns - 1];
	}
}

public class UniquePathII {

	public static void main(String[] args) {
		int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		UniquePathIISolution solution = new UniquePathIISolution();
		System.out.println("No of paths :" + solution.uniquePathsWithObstacles(obstacleGrid));
	}
}
