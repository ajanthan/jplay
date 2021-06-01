package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * <p>
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 * <p>
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 * <p>
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 * <p>
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3
 * Last three and first characters are same.  We basically
 * need to convert "un" to "atur".  This can be done using
 * below three operations.
 * Replace 'n' with 'r', insert t, insert a
 */

public class EditDistance {
    //"geek", "gesek"
    //eek sek
    public int getMinOpToChangeV1(String s1, String s2) {
        return getMinOpToChangeV1(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    private int getMinOpToChangeV1(String s1, int i, String s2, int j) {
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0 && j >= 0) {
            return j + 1;
        }
        if (j < 0 && i >= 0) {
            return i + 1;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return getMinOpToChangeV1(s1, i - 1, s2, j - 1);
        } else {
            return Math.min(1 + getMinOpToChangeV1(s1, i - 1, s2, j - 1), Math.min(1 + getMinOpToChangeV1(s1, i - 1, s2, j), 1 + getMinOpToChangeV1(s1, i, s2, j - 1)));
        }
    }

    public int getMinOpToChangeV2(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i < s1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < s2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i - 1][j - 1], Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j]));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
