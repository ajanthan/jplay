package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class MinDeleteToSort {
    public int getNumberOfDeletions(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return nums.length - max;
    }
}
