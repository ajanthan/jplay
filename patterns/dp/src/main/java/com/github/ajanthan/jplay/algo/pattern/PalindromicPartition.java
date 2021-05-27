package com.github.ajanthan.jplay.algo.pattern;

public class PalindromicPartition {
    public int minCutV0(String s) {
        return minCutRecursive(s, 0, s.length() - 1);
    }

    private int minCutRecursive(String s, int start, int end) {
        int currentCuts, minCuts = Integer.MAX_VALUE;
        if (start <= end && isPalindromic(s, start, end)) {
            return 0;
        } else {
            for (int j = start; j < end; j++) {
                //[a b c d]
                //[a b | c d]
                currentCuts = minCutRecursive(s, start, j) + 1 + minCutRecursive(s, j + 1, end);
                minCuts = Math.min(minCuts, currentCuts);
            }
        }
        return minCuts;
    }

    private boolean isPalindromic(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int minCutV1(String s) {
        boolean[][] plDP = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            plDP[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                plDP[i][i + 1] = true;
            }
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = s.length() - l; i >= 0; i--) {
                int j = i + l - 1;
                if (plDP[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    plDP[i][j] = true;
                }
            }
        }
        //geek
        //0123
        for (int i = 0; i < s.length(); i++) {
            if (plDP[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    if (plDP[k + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[k] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
