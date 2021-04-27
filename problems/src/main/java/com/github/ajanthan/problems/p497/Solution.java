package com.github.ajanthan.problems.p497;

import java.util.Arrays;

public class Solution {
    public int findTargetSumWaysV0(int[] nums, int target) {
        return findTargetSumWaysRecursively(nums, target, 0, 0);
    }

    private int findTargetSumWaysRecursively(int[] nums, int target, int currentIndex, int runningSum) {
        if (currentIndex == nums.length) {
            if (target == runningSum) {
                return 1;
            } else {
                return 0;
            }
        }
        int positiveCount = findTargetSumWaysRecursively(nums, target, currentIndex + 1, runningSum + nums[currentIndex]);
        int negativeCount = findTargetSumWaysRecursively(nums, target, currentIndex + 1, runningSum - nums[currentIndex]);
        return positiveCount + negativeCount;
    }

    public int findTargetSumWaysV1(int[] nums, int target) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return findTargetSumWaysRecursivelyV1(nums, target, 0, 0, memo);
    }

    private int findTargetSumWaysRecursivelyV1(int[] nums, int target, int currentIndex, int runningSum, int[][] memo) {
        if (currentIndex == nums.length) {
            if (target == runningSum) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[currentIndex][runningSum + 1000] != Integer.MIN_VALUE) {
            return memo[currentIndex][runningSum + 1000];
        }
        int positiveCount = findTargetSumWaysRecursively(nums, target, currentIndex + 1, runningSum + nums[currentIndex]);
        int negativeCount = findTargetSumWaysRecursively(nums, target, currentIndex + 1, runningSum - nums[currentIndex]);
        memo[currentIndex][runningSum + 1000] = positiveCount + negativeCount;
        return positiveCount + negativeCount;
    }

    public int findTargetSumWaysV2(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return target > 1000 ? 0 : dp[nums.length - 1][target + 1000];
    }

    public int findTargetSumWaysV3(int[] nums, int target) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return target > 1000 ? 0 : dp[target + 1000];
    }
}
