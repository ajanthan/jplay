package com.github.ajanthan.jplay.algo.pattern.fibnumber;

public class Fibonacci {
    public static int callCount = 0;

    public int calculateRecursively(int n) {
        callCount++;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return calculateRecursively(n - 1) + calculateRecursively(n - 2);
    }

    public int calculateIteratively(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int calculateRecursively(int n, int[] memoization) {
        callCount++;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (memoization[n - 1] != 0) {
            return memoization[n - 1];
        }
        memoization[n - 1] = calculateRecursively(n - 1, memoization) + calculateRecursively(n - 2, memoization);
        return memoization[n - 1];
    }
}
