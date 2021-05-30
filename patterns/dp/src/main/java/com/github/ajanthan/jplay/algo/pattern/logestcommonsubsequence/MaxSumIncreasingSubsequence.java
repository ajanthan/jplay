package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class MaxSumIncreasingSubsequence {
    //1, 101, 2, 3, 100, 4, 5
    public int getMaxSum(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
