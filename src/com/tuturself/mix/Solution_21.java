package com.tuturself.mix;


import java.util.LinkedList;
import java.util.Queue;

public class Solution_21 {

	public int orangesRotting(int[][] grid) {

		Queue<int[]> queue = new LinkedList();
		int rows = grid.length;
		int columns = grid[0].length;
		// All the rotten oranges
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[]{i, j});
				}
			}
		}

		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int level = 0;
		while (!queue.isEmpty()) {
			level++;
			for (int i = 0; i < queue.size(); i++) {
				int[] rotten = queue.poll();
				for(int[] dir : directions){
					int x = rotten[0] + dir[0];
					int y = rotten[1] + dir[1];
					if(x > rows || y > columns || x < 0 || y < 0 || grid[x][y] == 2){
						continue;
					}
					queue.offer(new int[]{x,y});
					grid[x][y] = 2;
				}
			}
		}
		// unreachable oranges
		for(int[] row : grid){
			for (int a : row){
				if(a == 1) return -1;
			}
		}
		return level == 0 ? -1 : level -1;
	}
}
