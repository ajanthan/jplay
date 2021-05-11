package com.github.ajanthan.jplay.algo.patterns.p6;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
    find the length of the longest substring having the same letters after replacement.
Example 1:
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:
Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:
Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.longestSubString("aabccbb", 2));
        System.out.println("Output: " + solution.longestSubString("abbcb", 1));
        System.out.println("Output: " + solution.longestSubString("abccde", 1));
    }

    public int longestSubString(String s, int k) {
        Map<Character, Integer> ht = new HashMap<>();

        int start = 0, end = 1, maxLength = 0, replacableChars = 0;
        char mainChar = s.charAt(start);
        while (end < s.length() && start + 1 <= end) {
            if (s.charAt(end) != mainChar) {
                replacableChars++;
            }
            while (replacableChars > k && start + 1 <= end) {
                if (mainChar == s.charAt(start + 1)) {
                    start++;
                } else {
                    mainChar = s.charAt(start + 1);
                    start++;
                    replacableChars--;
                    int i = start;
                    while (mainChar == s.charAt(i + 1)) {
                        i++;
                        replacableChars--;
                    }
                }
            }
            // System.out.println(s.substring(start, end + 1));
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
