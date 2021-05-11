package com.github.ajanthan.jplay.algo.patterns.p1;

import java.util.Arrays;

/*
Problem Statement
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
Example 1:
Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
Example 2:
Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + Arrays.toString(solution.getTwoSums(new int[]{ 1, 2, 3, 4, 6 }, 6)));
        System.out.println("Output: " + Arrays.toString(solution.getTwoSums(new int[]{ 2, 5, 9, 11 }, 11)));
        System.out.println("Output: " + Arrays.toString(solution.getTwoSums(new int[]{ 2, 5, 9 }, 12)));
        System.out.println("Output: " + Arrays.toString(solution.getTwoSums(new int[]{}, 12)));
    }

    public int[] getTwoSums(int[] nums, int target) {
        int left = 0, right = nums.length - 1, currentSum;
        while (left < right) {
            currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                return new int[]{ left, right };
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
