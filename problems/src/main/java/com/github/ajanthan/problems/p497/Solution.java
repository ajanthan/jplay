package com.github.ajanthan.problems.p497;

public class Solution {
    public int findTargetSumWaysV0(int[] nums, int target) {
        return findTargetSumWaysRecursively(nums, target, -1, 0);
    }

    private int findTargetSumWaysRecursively(int[] nums, int target, int currentIndex, int runningSum) {
        currentIndex++;
        if (currentIndex >= nums.length) {
            if (target == runningSum) {
                return 1;
            } else {
                return 0;
            }
        }
        int positiveCount = findTargetSumWaysRecursively(nums, target, currentIndex, runningSum + nums[currentIndex]);
        int negativeCount = findTargetSumWaysRecursively(nums, target, currentIndex, runningSum - nums[currentIndex]);
        return positiveCount + negativeCount;
    }
}
