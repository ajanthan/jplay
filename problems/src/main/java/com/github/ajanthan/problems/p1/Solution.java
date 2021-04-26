package com.github.ajanthan.problems.p1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ht = new HashMap<>();
        int[] ret = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(target - nums[i])) {
                int item = ht.get(target - nums[i]);
                ret[1] = i;
                ret[0] = item;
                return ret;
            }
            ht.put(nums[i], i);
        }
        return null;
    }
}
