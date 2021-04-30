package com.github.ajanthan.problems.p3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringV0(String s) {
        if (s.length() < 2) return s.length();
        String subs;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                subs = s.substring(i, j);
                if (subs.indexOf(s.charAt(j)) == -1) {
                    if (subs.length() + 1 > maxLength) {
                        maxLength = subs.length() + 1;
                    }
                } else {
                    if (subs.length() > maxLength) {
                        maxLength = subs.length();
                    }
                    break;
                }
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringV1(String s) {
        if (s.length() < 2) return s.length();
        Map<Character, Integer> ht = new HashMap<>();
        int start = 0, e = 1, max = 0;
        ht.put(s.charAt(0), 0);
        while (e < s.length() && start < s.length()) {
            if (!ht.containsKey(s.charAt(e))) {
                ht.put(s.charAt(e), e);
                if (ht.size() > max) max = ht.size();
                e++;
            } else {
                ht.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringV2(String s) {
        Map<Character, Integer> ht = new HashMap<>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ht.containsKey(s.charAt(i))) {
                start = Math.max(start, ht.get(s.charAt(i))) + 1;
            }
            ht.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
