package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class LongestAlternatingSequence {
    public int getMaxLengthV0(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int maxLength = 2;
        dp[0][0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j][1] == 0) {
                    if (nums[i] > nums[j]) {
                        dp[i][0] = 2;
                        dp[i][1] = 1;
                    }
                    if (nums[i] < nums[j]) {
                        dp[i][0] = 2;
                        dp[i][1] = 2;
                    }
                } else if (dp[j][1] == 1) {
                    if (nums[i] < nums[j]) {
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                        dp[i][1] = 2;
                    }
                } else if (dp[j][1] == 2) {
                    if (nums[i] > nums[j]) {
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                        dp[i][1] = 1;
                    }
                }
                maxLength = Math.max(maxLength, dp[i][0]);
            }
        }
        return maxLength;
    }

    public int getMaxLengthV1(int[] nums) {
        int greaterCounter = 1, lesserCounter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                greaterCounter = lesserCounter + 1;
            }
            if (nums[i] < nums[i - 1]) {
                lesserCounter = greaterCounter + 1;
            }
        }
        return Math.max(greaterCounter, lesserCounter);
    }
}
