package com.github.ajanthan.jplay.algo.pattern.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Statement
Given a set with distinct elements, find all of its distinct subsets.
Example 1:
Input: [1, 3]
Output: [], [1], [3], [1,3]
Example 2:
Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getSubsets(new int[]{ 1, 3 }));
        System.out.println("Output: " + solution.getSubsets(new int[]{ 1, 5, 3 }));

        System.out.println("Output: " + solution.getSubsetsV0(new int[]{ 1, 3 }));
        System.out.println("Output: " + solution.getSubsetsV0(new int[]{ 1, 5, 3 }));
    }

    public List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubSets(nums, 0, res);
        return res;
    }

    public List<List<Integer>> getSubsetsV0(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubSetsV0(nums, res);
        return res;
    }

    private void generateSubSets(int[] nums, int currentIndex, List<List<Integer>> res) {
        if (currentIndex == 0) {
            res.add(new ArrayList<Integer>());
        }
        if (currentIndex < nums.length) {
            List<List<Integer>> prev = new ArrayList<>(res);
            for (List<Integer> l : prev) {
                List<Integer> ll = new ArrayList<Integer>(l);
                ll.add(nums[currentIndex]);
                res.add(ll);
            }
            generateSubSets(nums, currentIndex + 1, res);
        }
    }

    private void generateSubSetsV0(int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> prev = new ArrayList<>(res);
            for (List<Integer> l : prev) {
                List<Integer> ll = new ArrayList<Integer>(l);
                ll.add(nums[i]);
                res.add(ll);
            }
        }
    }
}
