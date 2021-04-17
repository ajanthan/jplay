package com.github.ajanthan.problems.p169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElementV0(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            Integer i = occurrences.get(num);
            if (i == null) {
                occurrences.put(num, 1);
            } else {
                occurrences.put(num, i + 1);
            }
        }
        for (int majorityEl : occurrences.keySet()) {
            if (occurrences.get(majorityEl) > (nums.length / 2)) return majorityEl;
        }
        return 0;
    }

    public int majorityElementV1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElementV2(int[] nums) {
        int count = 0, majorityNumber = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                majorityNumber = num;
            } else {
                if (majorityNumber == num) count++;
                else count--;
            }
        }
        return majorityNumber;
    }

    public int majorityElementV3(int[] nums) {
        return findMajorityElementRec(nums, 0, nums.length - 1);
    }

    private int findMajorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = lo + (hi - lo) / 2;
        int left = findMajorityElementRec(nums, lo, mid);
        int right = findMajorityElementRec(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
