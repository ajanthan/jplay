package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class StringTransform {
    public Result getNumberOfDelIns(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        for (int i = 0; i < s1.length() + 1; i++) {
//            dp[i][0] = 0;
//        }
//        for (int i = 0; i < s2.length() + 1; i++) {
//            dp[0][i] = 0;
//        }
        int maxLength = 0;
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return new Result(s1.length() - maxLength, s2.length() - maxLength);
    }

    class Result {
        int deletions;
        int insertions;

        public Result(int del, int ins) {
            this.insertions = ins;
            this.deletions = del;
        }
    }
}
