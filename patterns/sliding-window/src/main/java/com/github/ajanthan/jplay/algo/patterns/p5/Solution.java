package com.github.ajanthan.jplay.algo.patterns.p5;

/*
Problem Statement
Given a string, find the length of the longest substring which has no repeating characters.
Example 1:
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Example 2:
Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
Example 3:
Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.longestSubstring("aabccbb"));
        System.out.println("Output: " + solution.longestSubstring("abbbb"));
        System.out.println("Output: " + solution.longestSubstring("abccde"));
        System.out.println("Output: " + solution.longestSubstring("a"));
        System.out.println("Output: " + solution.longestSubstring(""));
    }

    public int longestSubstring(String s) {
        StringBuilder currentSubs = new StringBuilder("");
        int start = 0, end = 0, maxLength = 0;
        while (end < s.length() && end >= start) {
            while (currentSubs.indexOf(String.valueOf(s.charAt(end))) >= 0 && end >= start) {
                currentSubs.deleteCharAt(0);
                start++;
            }

            if (currentSubs.indexOf(String.valueOf(s.charAt(end))) < 0) {
                currentSubs.append(s.charAt(end));
                end++;
            }
            maxLength = Math.max(maxLength, currentSubs.length());

        }
        return maxLength;
    }
}
