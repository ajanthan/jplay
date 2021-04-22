package com.github.ajanthan.problems.p221;

public class Solution {
    public int maximalSquareV0(char[][] matrix) {
        int maxArea = 0, currentArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    for (int length = 0; length <= matrix[i].length - i - 1; length++) {
                        if (length <= matrix.length - j - 1) {
                            currentArea = isSquareSubMatrix(i, j, length, matrix);
                            if (currentArea > maxArea) {
                                maxArea = currentArea;
                            }
                        }
                    }
                }
            }
        }
        return maxArea;
    }

    private int isSquareSubMatrix(int row, int column, int length, char[][] matrix) {
        for (int i = row; i <= length + row; i++) {
            for (int j = column; j <= length + column; j++) {
                if (matrix[i][j] != '1') {
                    return 0;
                }
            }
        }
        return (length + 1) * (length + 1);
    }
}
