package com.github.ajanthan.problems.array;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int single = nums[0];
        for (int i = 1; i < nums.length; ) {
            if (single == nums[i]) {
                if (++i < nums.length) {
                    single = nums[i];
                }
            }
            i++;
        }
        return single;
    }
}
