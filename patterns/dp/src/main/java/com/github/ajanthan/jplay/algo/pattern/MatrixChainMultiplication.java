package com.github.ajanthan.jplay.algo.pattern;

/*
Given matrices A1, A2, .., An,
where Ai
 is a di-1 x di
 matrix.
[1] What is minimum number of scalar multiplications required to
compute the product A1
· A2 ·... · An?
[2] What order of matrix multiplications achieves this minimum?

 */
public class MatrixChainMultiplication {
    public int minOperationMultiplicationV0(int[] p) {
        return minOperationMultiplicationV0(p, 1, p.length - 1);
    }

    private int minOperationMultiplicationV0(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        int currentCount, minCount = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            currentCount = minOperationMultiplicationV0(p, i, k) + minOperationMultiplicationV0(p, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (currentCount < minCount) {
                minCount = currentCount;
            }
        }
        return minCount;
    }

    public int minOperationMultiplicationV1(int[] p) {
        int[][] dp = new int[p.length][p.length];
        for (int i = 0; i < p.length; i++) {
            dp[i][i] = 0;
        }
        //[1,2,3,4]
        //   i   j
        for (int l = 2; l < p.length; l++) {
            for (int i = 1; i < p.length + 1 - l; i++) {
                int j = i + l - 1;
                int currentCount;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    currentCount = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(currentCount, dp[i][j]);
                }
            }
        }
        return dp[1][p.length - 1];
    }
}
