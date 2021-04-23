package com.github.ajanthan.problems.p53;

public class Solution {
    public int maxSubArrayV0(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0], currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    public int maxSubArrayV1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i] + currentSum) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
