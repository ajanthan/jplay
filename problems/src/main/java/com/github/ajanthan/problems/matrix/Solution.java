package com.github.ajanthan.problems.matrix;

import java.util.ArrayList;
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
}
