package com.github.ajanthan.jplay.algo.patterns.p1;
/*
Problem Statement #
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Example 2:
Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
 */

public class Solution {
    /*
    time: O(N)
    space: O(1)
     */
    public int getMaxSum(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0, i = 0, j = 0;

        while (j < nums.length && i < nums.length - k) {
            currentSum += nums[j];
            if (j >= k) {
                currentSum = currentSum - nums[i];
                maxSum = Math.max(currentSum, maxSum);
                i++;
            }
            j++;

        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("output: " + solution.getMaxSum(new int[]{ 2, 1, 5, 1, 3, 2 }, 3));
        System.out.println("output: " + solution.getMaxSum(new int[]{ 2, 3, 4, 1, 5 }, 2));
    }
}
