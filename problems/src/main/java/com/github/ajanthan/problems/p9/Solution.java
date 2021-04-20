package com.github.ajanthan.problems.p9;

public class Solution {
    public boolean isPalindromeV1(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeV2(int x) {
        if (x < 0) {
            return false;
        }
        int r = 0, y = x;
        while (y != 0) {
            r = r * 10 + y % 10;
            y = y / 10;
        }
        return r == x;
    }

    public boolean isPalindromeV3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse == x || reverse / 10 == x;
    }
}
