package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of
 * a given sequence such that all elements of the subsequence are sorted in increasing order
 * <p>
 * Input: arr[] = {3, 10, 2, 1, 20}
 * Output: Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 * <p>
 * Input: arr[] = {3, 2}
 * Output: Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 * <p>
 * Input: arr[] = {50, 3, 10, 7, 40, 80}
 * Output: Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 */
public class LongestIncreasingSubsequence {
    public int getLengthV1(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }

    public int getLengthV0(int[] nums) {
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            maxLength = Math.max(maxLength, getMaxLengthRecursive(nums, i));
        }
        return maxLength;
    }

    private int getMaxLengthRecursive(int[] nums, int i) {
        if (i == 0) {
            return 1;
        }
        int l = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                l = Math.max(l, 1 + getMaxLengthRecursive(nums, j));
            }
        }
        return l;
    }

    public int getLengthV2(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0, left, right, mid;
        for (int num : nums) {
            left = 0;
            right = length;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (num > dp[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == length) {
                length++;
            }
        }
        return length;
    }
}
