package com.github.ajanthan.jplay.algo.pattern.zerooneknapsack;

public class EqualSumSubsets {
    public boolean hasEqualSumSubsetV0(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return hasEqualSumSubsetRecursively(nums, 0, sum / 2);
    }

    public boolean hasEqualSumSubsetV1(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return hasEqualSumSubsetRecursively(nums, 0, sum / 2, new Boolean[nums.length][(sum / 2) + 1]);
    }

    public boolean hasEqualSumSubsetV2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int s = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][s + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= s; i++) {
            dp[0][i] = nums[0] == s;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= s; j++) {
                boolean found1 = false, found2 = false;
                if (dp[i - 1][j] != null) {
                    found1 = dp[i - 1][j];
                }
                if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]] != null) {
                    found2 = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = found1 || found2;
            }
        }

        return dp[nums.length - 1][s];
    }

    private boolean hasEqualSumSubsetRecursively(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || i >= nums.length) {
            return false;
        }
        return hasEqualSumSubsetRecursively(nums, i + 1, target - nums[i]) || hasEqualSumSubsetRecursively(nums, i + 1, target);
    }

    private boolean hasEqualSumSubsetRecursively(int[] nums, int i, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || i >= nums.length) {
            return false;
        }
        boolean reWithI = false, reWithoutI;
        if (memo[i][target] == null) {
            if (nums[i] <= target) {
                reWithI = hasEqualSumSubsetRecursively(nums, i + 1, target - nums[i]);
            }
            reWithoutI = hasEqualSumSubsetRecursively(nums, i + 1, target);
            memo[i][target] = reWithI || reWithoutI;
        }


        return memo[i][target];
    }
}
