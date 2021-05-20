package com.github.ajanthan.jplay.algo.pattern.unboundedknapsack;

public class UnboundedKnapsack {
    //new int[]{ 1, 30 }, new int[]{ 1, 50 }, 100
    public int getMaxValueV0(int[] values, int[] weights, int weight) {
        return getMaxValueRecursively(values, weights, weight);
    }

    public int getMaxValueV1(int[] values, int[] weights, int weight) {
        return getMaxValueRecursively(values, weights, weight, new Integer[weight + 1]);
    }

    public int getMaxValueV2(int[] values, int[] weights, int weight) {
        int[] dp = new int[weight + 1];
        dp[0] = 0;
        for (int i = 1; i <= weight; i++) {
            dp[i] = 0;
            for (int j = 0; j < values.length; j++) {
                if (i >= weights[j]) {
                    dp[i] = Math.max(dp[i], values[j] + dp[i - weights[j]]);
                }
            }
        }
        return dp[weight];
    }

    private int getMaxValueRecursively(int[] values, int[] weights, int weight) {
        if (weight == 0) {
            return 0;
        }
        int currentValue, maxValue = 0;
        for (int i = 0; i < values.length; i++) {
            if (weight >= weights[i]) {
                currentValue = values[i] + getMaxValueRecursively(values, weights, weight - weights[i]);
                maxValue = Math.max(maxValue, currentValue);
            }
        }
        return maxValue;
    }

    private int getMaxValueRecursively(int[] values, int[] weights, int weight, Integer[] memo) {
        if (weight == 0) {
            return 0;
        }
        if (memo[weight] == null) {
            int currentValue, maxValue = 0;
            for (int i = 0; i < values.length; i++) {
                if (weight >= weights[i]) {
                    currentValue = values[i] + getMaxValueRecursively(values, weights, weight - weights[i]);
                    maxValue = Math.max(maxValue, currentValue);
                }
            }
            memo[weight] = maxValue;
        }

        return memo[weight];
    }
}
