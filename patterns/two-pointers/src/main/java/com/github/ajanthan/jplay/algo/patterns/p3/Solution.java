package com.github.ajanthan.jplay.algo.patterns.p3;

import java.util.Arrays;

/*
Problem Statement
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:
Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + Arrays.toString(solution.getSquare(new int[]{ -2, -1, 0, 2, 3 })));
        System.out.println("Output: " + Arrays.toString(solution.getSquare(new int[]{ -3, -1, 0, 1, 2 })));
    }

    //[-2, -1, 0, 2, 3]
    public int[] getSquare(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0, end = nums.length - 1, i = end;
        while (start < nums.length && start < end) {
            if (nums[start] < 0) {
                if (Math.abs(nums[start]) > nums[end]) {
                    res[i] = nums[start] * nums[start];
                    i--;
                    start++;
                } else {
                    res[i] = nums[end] * nums[end];
                    i--;
                    end--;
                }

            } else {
                res[i] = nums[end] * nums[end];
                i--;
                end--;
            }
        }
        return res;
    }
}
