package com.github.ajanthan.problems.p26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int uArInx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[uArInx] != nums[i]) {
                nums[++uArInx] = nums[i];
            }
        }
        return uArInx + 1;
    }
}
