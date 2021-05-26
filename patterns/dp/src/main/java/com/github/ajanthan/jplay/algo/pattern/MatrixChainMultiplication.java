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
}
