package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class LCS {
    public int getLongestCommonSubsequenceV0(String text1, String text2) {
        return getLongestCommonSubsequenceRecursively(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    private int getLongestCommonSubsequenceRecursively(String text1, int i, String text2, int j) {
        int currentLength;
        if (i >= 0 && j >= 0) {
            if (text1.charAt(i) == text2.charAt(j)) {
                currentLength = 1 + getLongestCommonSubsequenceRecursively(text1, i - 1, text2, j - 1);
            } else {
                currentLength = Math.max(getLongestCommonSubsequenceRecursively(text1, i - 1, text2, j),
                    getLongestCommonSubsequenceRecursively(text1, i, text2, j - 1));
            }
            return currentLength;
        }
        return 0;
    }

    public int getLongestCommonSubsequenceV1(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= text2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
