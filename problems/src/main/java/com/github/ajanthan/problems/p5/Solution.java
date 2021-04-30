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

    public String longestPalindromeV1(String s) {
        int len = s.length(), max = 0, start = 0, end = 0;
        boolean sym;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sym = s.charAt(i) == s.charAt(j);
                dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] : sym;
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }

    public String longestPalindromeV2(String s) {
        int len = s.length(), max = 0, start = 0, end = 0;

        for (int i = 0; i < len; i++) {
            int l1 = expand(s, i, i);//odd
            int l2 = expand(s, i, i + 1);//even
            //2-1-2
            //0 1 2
            if (l1 > max) {
                max = l1;
                start = i - (l1 / 2);
                end = i + l1 / 2;
            }
            //1221
            //0123
            if (l2 > max) {
                max = l2;
                start = i - (l2 / 2) + 1;
                end = i + (l2 / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String st, int s, int e) {
        int l = 0, r = 0;
        while (s >= 0 && e < st.length() && st.charAt(s) == st.charAt(e)) {
            l = s;
            r = e;
            s--;
            e++;
        }
        return r - l + 1;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            //l[l][i][r]l
            //0 1  2  3 4
            //[l][i][i+1][r]
            //0   1   2   3
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return (R - L + 1) - 2;
    }
}
