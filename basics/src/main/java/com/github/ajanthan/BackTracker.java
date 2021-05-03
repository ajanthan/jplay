package com.github.ajanthan;

public class BackTracker {
    public boolean isReachable(int[][] grid, int x1, int y1, int x2, int y2) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return move(grid, visited, x1, y1, x2, y2);
    }

    private boolean move(int[][] grid, boolean[][] visited, int i, int j, int x, int y) {
        if (i < grid.length && j < grid[0].length && i >= 0 && j >= 0) {
            if (grid[i][j] == 0) {
                if (visited[i][j]) {
                    return false;
                }
                if (i == x && y == j) {
                    return true;
                }
                visited[i][j] = true;
            } else {
                return false;
            }
            boolean canMoveUp, canMoveDown, canMoveLeft, canMoveRight;
            canMoveUp = move(grid, visited, i, j + 1, x, y);
            canMoveDown = move(grid, visited, i, j - 1, x, y);
            canMoveLeft = move(grid, visited, i - 1, j, x, y);
            canMoveRight = move(grid, visited, i + 1, j, x, y);

            return canMoveUp || canMoveDown || canMoveLeft || canMoveRight;
        }
        return false;

    }
}
