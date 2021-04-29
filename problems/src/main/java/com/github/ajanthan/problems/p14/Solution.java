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
}
