package com.github.ajanthan.problems.p695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, currentArea;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                currentArea = measureArea(grid, i, j);
                maxArea = Math.max(currentArea, maxArea);
            }
        }
        return maxArea;
    }

    private int measureArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int left = measureArea(grid, i, j - 1);
        int right = measureArea(grid, i, j + 1);
        int up = measureArea(grid, i + 1, j);
        int down = measureArea(grid, i - 1, j);

        return left + right + up + down + 1;
    }

    public int countIslands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void markIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        markIsland(grid, i, j - 1);
        markIsland(grid, i, j + 1);
        markIsland(grid, i + 1, j);
        markIsland(grid, i - 1, j);
    }
}
