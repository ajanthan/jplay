package com.github.ajanthan.jplay.algo.pattern.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given a set of numbers that might contain duplicates, find all of its distinct subsets.
Example 1:
Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]
Example 2:
Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getDistinctSubArray(new int[]{ 1, 3, 3 }));
        System.out.println("Output: " + solution.getDistinctSubArray(new int[]{ 1, 5, 3, 3 }));
        System.out.println("Output: " + solution.getDistinctSubArray(new int[]{ 1, 5, 3, 3, 3 }));
    }

    public List<List<Integer>> getDistinctSubArray(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        List<List<Integer>> prev = null;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                List<List<Integer>> tempPrev = new ArrayList<>();
                for (List<Integer> l : prev) {
                    List<Integer> ll = new ArrayList<>(l);
                    ll.add(nums[i]);
                    tempPrev.add(ll);
                }
                result.addAll(tempPrev);
                prev = tempPrev;
            } else {
                prev = new ArrayList<>();
                for (List<Integer> l : result) {
                    List<Integer> ll = new ArrayList<>(l);
                    ll.add(nums[i]);
                    prev.add(ll);
                }
                result.addAll(prev);
            }
        }
        return result;
    }
}
