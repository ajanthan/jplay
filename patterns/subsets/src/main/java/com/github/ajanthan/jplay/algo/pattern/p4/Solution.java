package com.github.ajanthan.jplay.algo.pattern.p4;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement
Given a string, find all of its permutations preserving the character sequence but changing case.
Example 1:
Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52"
Example 2:
Input: "ab7c"
Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getPermutationsByCase("ad52"));
        System.out.println("Output: " + solution.getPermutationsByCase("ab7c"));
        System.out.println("Output: " + solution.getPermutationsByCase("ab"));
        System.out.println("Output: " + solution.getPermutationsByCase("12"));
        System.out.println("Output: " + solution.getPermutationsByCase("a?a"));
    }

    public List<String> getPermutationsByCase(String s) {
        List<String> result = new ArrayList<>();
        result.add(s);
        for (int i = 0; i < s.length(); i++) {
            List<String> temp = new ArrayList<>();
            for (String p : result) {
                Character c = s.charAt(i);
                if (Character.isAlphabetic(c)) {
                    c = Character.toUpperCase(c);
                    p = p.substring(0, i) + c + p.substring(i + 1);
                    temp.add(p);
                }
            }
            result.addAll(temp);
        }
        return result;
    }
}
