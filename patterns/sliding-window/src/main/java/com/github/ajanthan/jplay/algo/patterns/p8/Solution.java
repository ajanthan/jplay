package com.github.ajanthan.jplay.algo.patterns.p8;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
    Problem Challenge 1
Permutation in a String (hard)
Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters it will have n!n! permutations.
Example 1:
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:
Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.containsPermutation("oidbcaf", "abc"));
        System.out.println("Output: " + solution.containsPermutation("odicf", "dc"));
        System.out.println("Output: " + solution.containsPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Output: " + solution.containsPermutation("aaacb", "abc"));
        System.out.println("Output: " + solution.containsPermutation("abc", "abc"));
        System.out.println("Output: " + solution.containsPermutation("ab", "abc"));
    }

    public boolean containsPermutation(String s, String p) {
        Map<Character, Integer> his1 = new HashMap<>();
        Map<Character, Integer> his2 = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (his1.containsKey(c)) {
                his1.put(c, his1.get(c) + 1);
            } else {
                his1.put(c, 1);
            }
        }
        int end = 0;
        while (end < s.length()) {
            if (his1.containsKey(s.charAt(end))) {
                if (his2.containsKey(s.charAt(end))) {
                    his2.put(s.charAt(end), his2.get(s.charAt(end)) + 1);
                } else {
                    his2.put(s.charAt(end), 1);
                }
                if (his2.get(s.charAt(end)) > his1.get(s.charAt(end))) {
                    end++;
                    his2.clear();
                    continue;
                }

            } else {
                end++;
                if (!his2.isEmpty()) his2.clear();
                continue;
            }
            boolean matched = true;
            for (char c : his1.keySet()) {
                if (!his2.containsKey(c) || his2.get(c) != his1.get(c)) {
                    matched = false;
                }
            }
            if (matched) return true;
            end++;
        }
        return false;
    }
}
