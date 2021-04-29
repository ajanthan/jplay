package com.github.ajanthan.problems.p14;

public class Solution {
    public String longestCommonPrefixV0(String[] strs) {
        if (strs.length == 1) return strs[0];
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < lcp.length(); j++) {
                if (j >= strs[i].length() || lcp.charAt(j) != strs[i].charAt(j)) {
                    lcp = lcp.substring(0, j);
                    break;
                }
            }
        }
        return lcp;
    }

    public String longestCommonPrefixV1(String[] strs) {
        String lcp = strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || lcp.charAt(i) != strs[j].charAt(i)) {
                    return lcp.substring(0, i);
                }
            }
        }
        return null;
    }

    public String longestCommonPrefixV2(String[] strs) {
        return longestCommonPrefixInSubArrayV2(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefixInSubArrayV2(String[] strs, int s, int e) {
        if (s == e) return strs[s];
        int mid = (s + e) / 2;
        String leftLsp = longestCommonPrefixInSubArrayV2(strs, s, mid);
        String rightLsp = longestCommonPrefixInSubArrayV2(strs, mid + 1, e);

        int minLength = Math.min(leftLsp.length(), rightLsp.length());
        for (int i = 0; i < minLength; i++) {
            if (leftLsp.charAt(i) != rightLsp.charAt(i)) {
                return leftLsp.substring(0, i);
            }
        }
        return leftLsp.substring(0, minLength);
    }
}
