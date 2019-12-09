package com.tuturself.mix;

public class Solution_2 {

	int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	int height = 0, width = 0;
	int min = 0;
	boolean[][] visited;

	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0) return min;
		height = grid.length;
		width = grid[0].length;
		visited = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j] == 2) {
					dfs(grid, i, j);
				}
			}
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j] == 1) {
					min = -1;
					break;
				}
			}
		}
		return min;
	}

	private void dfs(int[][] grid, int i, int j) {
		boolean found = false;
		visited[i][j] = true;
		for (int[] direction : directions) {
			int x = (i + direction[0]);
			int y = (j + direction[1]);
			if (x >= 0 && x < height && y >= 0 && y < width && grid[x][y] == 1 && !visited[x][y]) {
				found = true;
				grid[x][y] = 2;
				dfs(grid,x,y);
			}
		}
		if (found) min++;
	}
}
