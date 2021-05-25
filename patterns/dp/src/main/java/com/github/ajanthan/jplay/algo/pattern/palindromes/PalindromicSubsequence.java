package com.github.ajanthan.jplay.algo.pattern.palindromes;

public class PalindromicSubsequence {
    public int getLongestPalindromicSubsequenceV0(String s) {
        return getLongestPalindromicSubsequenceRecursive(s, 0, s.length() - 1);
    }

    private int getLongestPalindromicSubsequenceRecursive(String s, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (s.charAt(start) == s.charAt(end)) {
            return 2 + getLongestPalindromicSubsequenceRecursive(s, start + 1, end - 1);
        } else {
            return Math.max(getLongestPalindromicSubsequenceRecursive(s, start, end - 1),
                getLongestPalindromicSubsequenceRecursive(s, start + 1, end));
        }
    }

    public int getLongestPalindromicSubsequenceV1(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public int minimumNumberOfDeletion(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        // bbbab
        //b
        for (int left = s.length() - 1; left >= 0; left--) {
            for (int right = left + 1; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = 2 + dp[left + 1][right - 1];
                } else {
                    dp[left][right] = Math.max(dp[left][right - 1], dp[left + 1][right]);
                }
            }
        }
        return s.length() - dp[0][s.length() - 1];
    }
}
