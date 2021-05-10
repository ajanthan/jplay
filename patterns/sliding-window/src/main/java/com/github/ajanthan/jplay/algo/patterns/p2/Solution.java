package com.github.ajanthan.jplay.algo.patterns.p2;

/*
Problem Statement
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
Example 1:
Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
Example 2:
Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:
Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getSmallestSubArrayLength(new int[]{ 2, 1, 5, 2, 3, 2 }, 7));
        System.out.println("Output: " + solution.getSmallestSubArrayLength(new int[]{ 2, 1, 5, 2, 8 }, 7));
        System.out.println("Output: " + solution.getSmallestSubArrayLength(new int[]{ 3, 4, 1, 1, 6 }, 8));
    }

    public int getSmallestSubArrayLength(int[] nums, int s) {
        /*
        time: O(N)
        space: O(1)
         */
        int smallest = Integer.MAX_VALUE, left = 0, right = 0, currentSum = nums[0];
        while (right < nums.length - 1 && left <= right) {

            if (currentSum < s) {
                currentSum += nums[++right];
            }
            while (currentSum >= s && left <= right) {
                smallest = Math.min(right - left + 1, smallest);
                currentSum -= nums[left];
                left++;
            }
        }
        return smallest;
    }
}
