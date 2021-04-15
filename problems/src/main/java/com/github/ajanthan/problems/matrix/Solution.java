package com.github.ajanthan.problems.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
    A lucky number is an element of the matrix such that it is
    the minimum element in its row and maximum in its column.
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumber = new ArrayList<>();
        int minRow = 0, maxCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][minRow] > matrix[i][j]) minRow = j;
            }
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[maxCol][minRow] < matrix[k][minRow]) maxCol = k;
            }
            if (i == maxCol) {
                luckyNumber.add(matrix[i][minRow]);
            }
        }
        return luckyNumber;
    }

    public List<Integer> luckyNumbersV1(int[][] matrix) {
        List<Integer> luckyNumber = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[] maxCols = new int[n], minRows = new int[m];
        Arrays.fill(minRows, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minRows[i]) minRows[i] = matrix[i][j];
                if (matrix[i][j] > maxCols[j]) maxCols[j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maxCols[j] == minRows[i]) {
                    luckyNumber.add(matrix[i][j]);
                    break;
                }
            }
        }
        return luckyNumber;
    }
}
