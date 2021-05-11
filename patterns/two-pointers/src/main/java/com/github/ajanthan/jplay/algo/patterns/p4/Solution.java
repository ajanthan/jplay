package com.github.ajanthan.jplay.algo.patterns.p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
Example 1:
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
Example 2:
Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getTriplets(new int[]{ -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println("Output: " + solution.getTriplets(new int[]{ -5, 2, -1, -2, 3 }));
    }

    public List<List<Integer>> getTriplets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int start, end, currentSum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                currentSum = nums[start] + nums[end];
                if (currentSum == -nums[i]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    ret.add(l);
                    start++;
                    end--;
                    while (end > start && nums[end] == nums[end + 1]) {
                        end--;
                    }
                    while (end > start && nums[start] == nums[start - 1]) {
                        start++;
                    }
                } else if (currentSum > -nums[i]) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ret;
    }
}
