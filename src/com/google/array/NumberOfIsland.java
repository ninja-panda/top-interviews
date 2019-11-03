package com.google.array;

class NumberOfIslandSolution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int no = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    no++;
                    DFS(grid, i, j);
                }
            }
        }
        return no;
    }

    private void DFS(char[][] grid, int i, int j) {
        int height = grid.length;
        int width = grid[0].length;
        if (i < 0 || j < 0 || i >= height || j >= width || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        DFS(grid, (i - 1), j);
        DFS(grid, (i + 1), j);
        DFS(grid, i, (j + 1));
        DFS(grid, i, (j - 1));
    }
}

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIslandSolution solution = new NumberOfIslandSolution();
        System.out.println("Number of Island: " + solution.numIslands(matrix));
    }
}
