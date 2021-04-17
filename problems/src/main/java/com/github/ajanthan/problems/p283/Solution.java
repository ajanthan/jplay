package com.github.ajanthan.problems.p283;

public class Solution {
    public void moveZeroesV0(int[] nums) {
        int lastIndexOfZero = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                swapUntil(nums, i, lastIndexOfZero);
                lastIndexOfZero--;
            }
        }
    }

    public void swapUntil(int[] nums, int from, int to) {
        for (int i = from; i < to; i++) {
            int temp = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = temp;
        }
    }

    public void moveZeroesV1(int[] nums) {
        int noneZerosIndex = 0;
        int[] res = new int[nums.length];
        for (int i : nums) {
            if (i != 0) {
                res[noneZerosIndex] = i;
                noneZerosIndex++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    public void moveZeroesV2(int[] nums) {
        int lastNoneZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNoneZeroIndex++] = nums[i];
            }
        }
        for (int j = lastNoneZeroIndex; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroesV3(int[] nums) {
        for (int lastNoneZeroIndex = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, lastNoneZeroIndex++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = j;
        nums[j] = temp;
    }
}
