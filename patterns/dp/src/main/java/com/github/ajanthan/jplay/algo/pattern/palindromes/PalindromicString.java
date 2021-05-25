package com.github.ajanthan.jplay.algo.pattern.palindromes;

public class PalindromicString {
    //forgeeksskeegfor
    public String getLongestSubstringV0(String s) {
        int maxLength = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i), s2 = "";

            if (i + 1 < s.length()) {
                s2 = expand(s, i, i + 1);
            }
            //aabaa
            //01234
            if (s1.length() > maxLength) {
                maxLength = s1.length();
                res = s1;
            }
            // aaaa
            // 1234
            if (s2.length() > maxLength) {
                maxLength = s2.length();
                res = s2;
            }
        }
        return res;
    }

    private String expand(String s, int start, int end) {
        int left = start, startP = 0, endP = 0, right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            startP = left;
            endP = right;
            left--;
            right++;
        }
        return s.substring(startP, endP + 1);
    }

    public String getLongestSubstringV1(String s) {
        int maxLength = 0, start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        start = i;
                        maxLength = l;
                    }
                }
            }
        }
        //aabaa
        //01234
        return s.substring(start, start + maxLength);
    }
}
