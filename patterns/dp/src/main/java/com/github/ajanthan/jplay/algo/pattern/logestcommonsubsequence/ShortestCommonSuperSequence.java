package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class ShortestCommonSuperSequence {
    //"geek",  "eke" => ek 4+1=5
    //"AGGTAB", "GXTXAYB" => GTAB 6+7-4=9
    public int getLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        for (int i = 0; i < s2.length() + 1; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 1; i < s1.length() + 1; i++) {
//            dp[i][0] = 0;
//        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return s1.length() + s2.length() - dp[s1.length()][s2.length()];
    }
}
