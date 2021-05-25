package com.github.ajanthan.jplay.algo.pattern.palindromes;

public class PalindromicString {
    //forgeeksskeegfor
    public String getLongestSubstring(String s) {
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
}
