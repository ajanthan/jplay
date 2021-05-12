package com.github.ajanthan.jplay.algo.patterns.p6;

import java.util.Arrays;

/*
Problem Statement
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
 arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function
 to return the count of such triplets.
Example 1:
Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
Example 2:
Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.findTriplets(new int[]{ -1, 0, 2, 3 }, 3));
        System.out.println("Output: " + solution.findTriplets(new int[]{ -1, 4, 2, 1, 3 }, 5));
        System.out.println("Output: " + solution.findTriplets(new int[]{ -1, 4, 2 }, 5));
        System.out.println("Output: " + solution.findTriplets(new int[]{ -1, 4, 1 }, 5));
    }

    public int findTriplets(int[] nums, int target) {
        int start, end, tripletCount = 0, currentSum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                currentSum = nums[i] + nums[start] + nums[end];
                if (currentSum < target) {
                    tripletCount += end - start;
                    start++;
                    //0 1 2 3 4 5
                    //  *       *
                    //end--;
                } else { //currentSum >= target
                    end--;
                }
            }
        }
        return tripletCount;
    }
}
