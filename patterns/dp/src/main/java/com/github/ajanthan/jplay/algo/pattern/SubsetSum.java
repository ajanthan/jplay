package com.github.ajanthan.jplay.algo.pattern;

/*
Given a set of non-negative integers, and a value sum,
determine if there is a subset of the given set with sum equal to given sum.
 */
public class SubsetSum {
    public boolean hasSubsetWithSum(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = nums[0] == i;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                //without current index
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }
}
