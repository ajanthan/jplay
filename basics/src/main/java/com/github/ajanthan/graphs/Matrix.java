package com.github.ajanthan.graphs;

public class Matrix {
    public int[][] findNearestZero(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < m; c++) {
                boolean[][] seen = new boolean[m][n];
                result[r][c] = findNearestZero(mat, r, c, seen);
            }
        }
        return result;
    }

    private int findNearestZero(int[][] mat, int r, int c, boolean[][] seen) {
        int m = mat.length, n = mat[0].length;
        if (r >= 0 && r < m && c >= 0 && c < n && !seen[r][c]) {
            seen[r][c] = true;
            if (mat[r][c] == 0) {
                return 0;
            }
            int minDistance = m + n;
            minDistance = Math.min(minDistance, findNearestZero(mat, r + 1, c, seen));
            minDistance = Math.min(minDistance, findNearestZero(mat, r - 1, c, seen));
            minDistance = Math.min(minDistance, findNearestZero(mat, r, c + 1, seen));
            minDistance = Math.min(minDistance, findNearestZero(mat, r, c - 1, seen));
            return minDistance + 1;
        }
        return m + n;
    }
}
