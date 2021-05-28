package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import java.util.Arrays;

/**
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 * Output : 5
 * Explanation:
 * The longest common substring is “Geeks” and is of length 5.
 */
public class LongestCommonSubstring {
    public int getLengthV0(String text1, String text2) {
        return getLengthV0(text1, text1.length() - 1, text2, text2.length() - 1, 0);
    }

    private int getLengthV0(String text1, int i, String text2, int j, int l) {
        if (i < 0 || j < 0) {
            return l;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return getLengthV0(text1, i - 1, text2, j - 1, l + 1);
        } else {
            return Math.max(l, Math.max(getLengthV0(text1, i, text2, j - 1, 0),
                Math.max(getLengthV0(text1, i - 1, text2, j, 0), getLengthV0(text1, i - 1, text2, j - 1, 0))));
        }
    }

    public int getLengthV1(String text1, String text2) {
        int longestLength = Integer.MIN_VALUE;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text2.length() + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < text1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    longestLength = Math.max(longestLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        return longestLength;
    }
}
