package com.github.ajanthan.problems.p27;

public class Solution {
    public int removeElementV1(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int lastZeroIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[lastZeroIndex];
                nums[lastZeroIndex] = -1;
                lastZeroIndex--;
            }
        }
        return lastZeroIndex + 1;
    }

    public int removeElementV2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
