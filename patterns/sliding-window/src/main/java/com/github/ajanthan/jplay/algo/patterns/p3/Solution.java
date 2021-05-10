package com.github.ajanthan.jplay.algo.patterns.p3;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement #
Given a string, find the length of the longest substring in it with no more than K distinct characters.
Example 1:
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:
Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:
Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getLongestSubstringWithKChars("araaci", 2));
        System.out.println("Output: " + solution.getLongestSubstringWithKChars("araaci", 1));
        System.out.println("Output: " + solution.getLongestSubstringWithKChars("cbbebi", 3));
    }

    public int getLongestSubstringWithKChars(String s, int k) {
        Map<Character, Integer> ht = new HashMap<>();
        int j = 0, maxLength = Integer.MIN_VALUE, currentSize;
        Character c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (ht.containsKey(c)) {
                ht.put(c, ht.get(c) + 1);
            } else {
                ht.put(c, 1);
            }
            currentSize = ht.keySet().size();
            while (currentSize > k && j <= i) {
                c = s.charAt(j);
                Integer count = ht.get(c);
                if (count == 1) {
                    ht.remove(c);
                } else {
                    ht.put(c, count - 1);
                }
                j++;
                currentSize = ht.keySet().size();
            }

            if (currentSize <= k) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }
}
