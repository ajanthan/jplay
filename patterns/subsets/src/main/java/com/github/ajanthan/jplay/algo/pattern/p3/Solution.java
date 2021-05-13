package com.github.ajanthan.jplay.algo.pattern.p3;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement
Given a set of distinct numbers, find all of its permutations.
Permutation is defined as the re-arranging of the elements of the set.
 For example, {1, 2, 3} has the following six permutations:
{1, 2, 3}
{1, 3, 2}
{2, 1, 3}
{2, 3, 1}
{3, 1, 2}
{3, 2, 1}
If a set has ‘n’ distinct elements it will have n! permutations.
Example 1:
Input: [1,3,5]
Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getPermutation(new int[]{ 1, 3, 5 }));
    }

    public List<List<Integer>> getPermutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutation(nums, 0, result);
        return result;
    }

    //[1  3,5
    //[3  1,5
    //[5  3,1
    private void getPermutation(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) {
                temp.add(n);
            }
            result.add(temp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            getPermutation(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
