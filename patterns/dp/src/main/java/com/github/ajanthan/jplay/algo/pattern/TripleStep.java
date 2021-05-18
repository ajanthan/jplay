package com.github.ajanthan.jplay.algo.pattern;

public class TripleStep {
    public int getPossibleWaysV1(int steps) {
        if (steps == 1) return 1;
        else if (steps == 2) return 2;
        else if (steps == 3) return 3;
        return getPossibleWaysV1(steps - 1) + getPossibleWaysV1(steps - 2) + getPossibleWaysV1(steps - 3);
    }

    public int getPossibleWaysV2(int steps) {
        int[] dp = new int[steps + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[steps];
    }
}
