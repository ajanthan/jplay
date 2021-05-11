package com.github.ajanthan.jplay.algo.patterns.p7;

/*

Problem Statement
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the
longest contiguous subarray having all 1s.
Example 1:
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
Example 2:
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.

 */
public class Solution {
    //[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.longestSubArray(new int[]{ 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println("Output: " + solution.longestSubArray(new int[]{ 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
        System.out.println("Output: " + solution.longestSubArray(new int[]{ 1, 1, 1, 1, 1 }, 2));
    }

    public int longestSubArray(int[] in, int k) {
        int start = 0, end, replaceableCount = 0, maxLength = 0;
        for (end = 0; end < in.length; end++) {
            if (in[end] == 0) {
                replaceableCount++;
            }
            while (replaceableCount > k && start <= end) {
                if (in[start] == 0) {
                    replaceableCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
