package com.google.array;

class PathFinder {

	int height, width;

	public int countPaths(int h, int w) {
		this.height = h;
		this.width = w;
		int[][] board = new int[h][w];
		board[0][w - 1] = 1;
		int count = backTrack(board, 0, 0);
		return count;
	}

	private int backTrack(int[][] board, int i, int j) {
		if (i >= height || j >= width || i < 0) return 0;
		if (board[i][j] != 0) return board[i][j];
		int c1 = backTrack(board, i, (j + 1));
		int c2 = backTrack(board, (i + 1), (j + 1));
		int c3 = backTrack(board, (i - 1), (j + 1));
		board[i][j] = (c1 + c2 + c3);
		return board[i][j];
	}
}

public class UniquePath_III {
	public static void main(String[] args) {
		PathFinder pathFinder = new PathFinder();
		int path = pathFinder.countPaths(3, 3);
		System.out.println(path);
	}
}
