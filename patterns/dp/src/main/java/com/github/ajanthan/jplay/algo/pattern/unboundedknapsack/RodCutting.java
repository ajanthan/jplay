package com.github.ajanthan.jplay.algo.pattern.unboundedknapsack;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example,
 * if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 */
public class RodCutting {
    public int maxTotalSaleV1(int[] lengths, int[] prices, int length) {
        int[] dp = new int[length + 1];
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {
            dp[i] = 0;
            for (int j = 0; j < lengths.length; j++) {
                if (i >= lengths[j]) {
                    dp[i] = Math.max(dp[i], prices[j] + dp[i - lengths[j]]);
                }
            }
        }
        return dp[length];
    }
}
