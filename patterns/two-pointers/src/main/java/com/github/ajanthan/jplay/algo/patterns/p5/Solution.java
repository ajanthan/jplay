package com.github.ajanthan.jplay.algo.patterns.p5;

import java.util.Arrays;

/*
Triplet Sum Close to Target (medium)
Problem Statement
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the
target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.
Example 1:
Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:
Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:
Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.findTripletSum(new int[]{ -2, 0, 1, 2 }, 2));
        System.out.println("Output: " + solution.findTripletSum(new int[]{ -3, -1, 1, 2 }, 1));
        System.out.println("Output: " + solution.findTripletSum(new int[]{ 1, 0, 1, 1 }, 100));
    }

    public int findTripletSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start, end, currentDelta, smallestDelta = Integer.MAX_VALUE, sum = Integer.MAX_VALUE, currentSum;
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                currentSum = (nums[start] + nums[end] + nums[i]);
                currentDelta = target - currentSum;

                if (Math.abs(currentDelta) == smallestDelta) {
                    sum = Math.min(sum, currentSum);
                } else if (Math.abs(currentDelta) < smallestDelta) {
                    smallestDelta = Math.abs(currentDelta);
                    sum = currentSum;
                }
                if ((currentDelta == 0)) {
                    start++;
                    end--;
                } else if (currentDelta > 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return sum;
    }
}
