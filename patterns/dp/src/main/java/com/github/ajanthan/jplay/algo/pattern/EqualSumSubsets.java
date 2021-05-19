package com.github.ajanthan.jplay.algo.pattern;

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
        Integer[][] dp = new Integer[nums.length][s + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        if (nums[0] <= s) {
            dp[0][nums[0]] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= s; j++) {
                if (dp[i - 1][j] != null) {
                    dp[i][j] = dp[i - 1][j];
                    if (nums[i] + j <= s) {
                        dp[i][j + nums[i]] = dp[i - 1][j] + nums[i];
                    }
                }

            }
        }

        for (Integer[] x : dp) {
            if (x[s] != null) {
                return true;
            }
        }
        return false;
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
        boolean reWithI, reWithoutI;
        if (memo[i][target - nums[i]] == null) {
            memo[i][target - nums[i]] = hasEqualSumSubsetRecursively(nums, i + 1, target - nums[i]);
        }
        reWithI = memo[i][target - nums[i]];

        if (memo[i][target] == null) {
            memo[i][target] = hasEqualSumSubsetRecursively(nums, i + 1, target);
        }
        reWithoutI = memo[i][target];
        return reWithI || reWithoutI;
    }
}
