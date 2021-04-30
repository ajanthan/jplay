package com.github.ajanthan.problems.p5;

public class Solution {
    public String longestPalindromeV0(String s) {
        String subs, lps = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                subs = s.substring(i, j);
                if (subs.length() > lps.length()) {
                    if (isPal(subs)) {
                        lps = subs;
                    }
                } else {
                    break;
                }
            }
        }
        return lps;
    }

    private boolean isPal(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
