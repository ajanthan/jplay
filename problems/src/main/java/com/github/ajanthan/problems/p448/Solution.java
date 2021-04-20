package com.github.ajanthan.problems.p448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbersV1(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                ret.add(i);
            }
        }
        return ret;
    }

    //{ 4, 3, 2, 7, 8, 2, 3, 1 }
    public List<Integer> findDisappearedNumbersV2(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[Math.abs(nums[j]) - 1] > 0) {
                nums[Math.abs(nums[j]) - 1] *= -1;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                ret.add(j + 1);
            }
        }
        return ret;
    }
}
