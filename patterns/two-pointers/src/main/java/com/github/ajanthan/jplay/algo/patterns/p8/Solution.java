package com.github.ajanthan.jplay.algo.patterns.p8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Challenge 1
Quadruple Sum to Target (medium)
Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
 whose sum is equal to the target number.
Example 1:
Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.
Example 2:
Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println("Output: " + solution.getQuadruplets(new int[]{ 4, 1, 2, -1, 1, -3 }, 1));
//        System.out.println("Output: " + solution.getQuadruplets(new int[]{ 2, 0, -1, 1, -2, 2 }, 2));
//        System.out.println("Output: " + solution.getQuadruplets(new int[]{ 1, 2, 3, 4 }, 10));
//        System.out.println("Output: " + solution.getQuadruplets(new int[]{ 1, 2, 3, 4 }, 9));
        System.out.println("Output: " + solution.getQuadruplets(new int[]{ 1, 1, 2, 2, 3, 3, 6, 4, 5, 6 }, 9));
    }

    public List<List<Integer>> getQuadruplets(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ret = new ArrayList<>();
        int start, end, sumDelta;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > 1 && nums[j] == nums[j - 1]) continue;
                start = j + 1;
                end = nums.length - 1;
                while (start < end) {
                    sumDelta = k - (nums[i] + nums[j] + nums[start] + nums[end]);
                    if (sumDelta == 0) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        while (start < end && nums[start] == nums[start - 1]) start++;
                        end--;
                        while (start < end && nums[end] == nums[end + 1]) end--;
                    } else if (sumDelta < 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return ret;
    }
}
