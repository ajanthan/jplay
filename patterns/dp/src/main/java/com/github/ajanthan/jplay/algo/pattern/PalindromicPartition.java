package com.github.ajanthan.jplay.algo.pattern;

public class PalindromicPartition {
    public int minCutV0(String s) {
        return minCutRecursive(s, 0, s.length() - 1);
    }

    private int minCutRecursive(String s, int start, int end) {
        int currentCuts, minCuts = Integer.MAX_VALUE;
        if (start <= end && isPalindromic(s, start, end)) {
            return 0;
        } else {
            for (int j = start; j < end; j++) {
                //[a b c d]
                //[a b | c d]
                currentCuts = minCutRecursive(s, start, j) + 1 + minCutRecursive(s, j + 1, end);
                minCuts = Math.min(minCuts, currentCuts);
            }
        }
        return minCuts;
    }

    private boolean isPalindromic(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
