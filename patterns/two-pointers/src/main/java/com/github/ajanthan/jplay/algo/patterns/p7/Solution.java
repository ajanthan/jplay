package com.github.ajanthan.jplay.algo.patterns.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given an array with positive numbers and a target number,
find all of its contiguous subarrays whose product is less than the target number.
Example 1:
Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.
Example 2:
Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getProductSubArrayV0(new int[]{ 2, 5, 3, 10 }, 30));
        System.out.println("Output: " + solution.getProductSubArrayV1(new int[]{ 2, 5, 3, 10 }, 30));
        System.out.println();
        System.out.println("Output: " + solution.getProductSubArrayV0(new int[]{ 8, 2, 6, 5 }, 50));
        System.out.println("Output: " + solution.getProductSubArrayV1(new int[]{ 8, 2, 6, 5 }, 50));
        System.out.println();
        System.out.println("Output: " + solution.getProductSubArrayV0(new int[]{ 8, 2, 6, 5, 20 }, 20));
        System.out.println("Output: " + solution.getProductSubArrayV1(new int[]{ 8, 2, 6, 5, 20 }, 20));
        System.out.println();
        System.out.println("Output: " + solution.getProductSubArrayV0(new int[]{ 1, 2, 3, 5, 6, 7, 20 }, 40));
        System.out.println("Output: " + solution.getProductSubArrayV1(new int[]{ 1, 2, 3, 5, 6, 7, 20 }, 40));
    }

    //wrong
    public List<List<Integer>> getProductSubArrayV0(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0, end = 1, runningProduct = nums[0];
        res.add(Arrays.asList(nums[0]));
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        while (end < nums.length) {
            if (nums[end] < k) {
                res.add(Arrays.asList(nums[end]));
            }
            runningProduct *= nums[end];
            l.add(nums[end]);
            while (runningProduct >= k && start <= end) {
                runningProduct /= nums[start];
                l.remove((Integer) nums[start]);
                start++;

            }
            if (runningProduct < k && start != end) {
                if (!l.isEmpty())
                    res.add(new ArrayList<Integer>(l));
            }
            end++;
        }

        return res;
    }

    //new int[]{ 2, 5, 3, 10 }, 30
    public List<List<Integer>> getProductSubArrayV1(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0, runningProduct = 1;
        for (int end = 0; end < nums.length; end++) {
            runningProduct *= nums[end];
            while (runningProduct >= k && start < nums.length) {
                runningProduct /= nums[start];
                start++;
            }
            List<Integer> l = new ArrayList<>();
            for (int j = end; j > start - 1; j--) {
                l.add(nums[j]);
                res.add(new ArrayList<Integer>(l));
            }
        }
        return res;
    }
}
