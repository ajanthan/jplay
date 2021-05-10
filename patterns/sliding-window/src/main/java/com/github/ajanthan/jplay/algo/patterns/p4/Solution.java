package com.github.ajanthan.jplay.algo.patterns.p4;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement
Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both the baskets.
Example 1:
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
Example 2:
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getMaxFruits(new char[]{ 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Output: " + solution.getMaxFruits(new char[]{ 'A', 'B', 'C', 'B', 'B', 'C' }));
    }

    public int getMaxFruits(char[] trees) {
        Map<Character, Integer> ht = new HashMap<>();
        int start = 0, end = 0, maxCount = 0;
        int count;
        while (end < trees.length && start <= end) {
            if (ht.containsKey(trees[end])) {
                count = ht.get(trees[end]);
                ht.put(trees[end], ++count);
            } else {
                ht.put(trees[end], 1);
            }
            while (ht.keySet().size() > 2 && start <= end) {
                count = ht.get(trees[end]);
                if (count == 1) {
                    ht.remove(trees[start]);
                } else {
                    ht.put(trees[end], --count);
                }
                start++;
            }
            if (ht.keySet().size() <= 2) {
                maxCount = Math.max(maxCount, end - start + 1);
            }
            end++;
        }
        return maxCount;
    }
}
