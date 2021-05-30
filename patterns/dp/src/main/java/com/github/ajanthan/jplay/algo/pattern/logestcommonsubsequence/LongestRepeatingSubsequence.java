package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class LongestRepeatingSubsequence {
    //AABEBCDD
//    public static int getMaxLengthV0(String s) {
//        boolean[] dp = new boolean[s.length()];
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!dp[i]) {
//                for (int j = i + 1; j < s.length(); j++) {
//                    if (s.charAt(i) == s.charAt(j)) {
//                        dp[i] = true;
//                        dp[j] = true;
//                        count++;
//                        break;
//                    }
//                }
//            }
//        }
//        return count;
//    }

    public static int getMaxLengthV1(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (s.charAt(i-1) == s.charAt(j-1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}
