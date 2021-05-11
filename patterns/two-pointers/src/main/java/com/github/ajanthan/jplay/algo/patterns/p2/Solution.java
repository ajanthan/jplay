package com.github.ajanthan.jplay.algo.patterns.p2;

/*
Problem Statement
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
after removing the duplicates in-place return the new length of the array.
Example 1:
Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:
Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("output: " + solution.removeDuplicates(new int[]{ 2, 3, 3, 3, 6, 9, 9 }));
        System.out.println("output: " + solution.removeDuplicates(new int[]{ 2, 2, 2, 11 }));
        System.out.println("output: " + solution.removeDuplicates(new int[]{ 2, 2, 2, 2 }));
        System.out.println("output: " + solution.removeDuplicates(new int[]{ 1, 2, 3, 3 }));
    }

    public int removeDuplicates(int[] nums) {
        int lastInsertIndex = 0, currentIndex = 1;
        while (currentIndex < nums.length) {
            if (nums[currentIndex] != nums[lastInsertIndex]) {
                nums[++lastInsertIndex] = nums[currentIndex];
            }
            currentIndex++;
        }
        return lastInsertIndex + 1;
    }
}
