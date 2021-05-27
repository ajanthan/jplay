package com.github.ajanthan.jplay.algo.pattern.zerooneknapsack;

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

    //t=s1+s2
    //d=s2-s1
    //d=s2-(t-s2)
    //d=2s2-t
    public int getMinimumSubsetSumDifference(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        return getMinimumSubsetSumDifference(nums, 0, 0, totalSum);
    }

    private int getMinimumSubsetSumDifference(int[] nums, int i, int sum, int total) {
        if (i == nums.length - 1) {
            return Math.abs(2 * sum - total);
        }
        int diff1, diff2;
        diff1 = getMinimumSubsetSumDifference(nums, i + 1, sum, total);
        diff2 = getMinimumSubsetSumDifference(nums, i + 1, sum + nums[i], total);
        return Math.min(diff1, diff2);
    }
//
//    public int getMinimumSubsetSumDifferenceV1(int[] nums) {
//        int totalSum = 0;
//        for (int i : nums) {
//            totalSum += i;
//        }
//        int[][] dp = new int[nums.length][totalSum];
//        int minDiff = Integer.MAX_VALUE;
//        boolean[][] sum = new boolean[nums.length][totalSum];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                sum[i][0] = true;
//            }
//        }
//        sum[0][nums[0]] = true;
//        minDiff = Math.min(minDiff, Math.abs(totalSum - nums[0]));
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 1; j < totalSum; j++) {
//                if (sum[i - 1][j]) {
//                    sum[i][j] = sum[i - 1][j];
//                    minDiff = Math.min(minDiff, Math.abs(totalSum - j));
//                }
//                if (j >= nums[i]) {
//                    if (sum[i - 1][j - nums[i]]) {
//                        sum[i][j] = true;
//                        minDiff = Math.min(minDiff, Math.abs(totalSum - j));
//                    }
//                }
//            }
//        }
//        return minDiff;
//    }
}
