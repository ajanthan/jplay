package com.github.ajanthan.jplay.algo.patterns.p10;

import java.util.Arrays;

/*
Problem Challenge 3
Minimum Window Sort (medium)
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
Example 1:
Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
Example 2:
Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
Example 3:
Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted
Example 4:
Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.findSmallestUnsortedV2(new int[]{ 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println("Output: " + solution.findSmallestUnsortedV2(new int[]{ 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println("Output: " + solution.findSmallestUnsortedV2(new int[]{ 1, 2, 3 }));
        System.out.println("Output: " + solution.findSmallestUnsortedV2(new int[]{ 3, 2, 1 }));
    }

    //[1, 2, 5, 3, 7, 10, 9, 12]
    public int findSmallestUnsorted(int[] nums) {
        int start = 0, end = nums.length - 1;
        if (nums[start] > nums[end]) {
            return end - start + 1;
        }
        boolean startFound = false, endFound = false;
        while (start < end) {
            if (start + 1 < end && nums[start + 1] < nums[end]) {
                if (nums[start + 1] >= nums[start]) {
                    start++;
                } else {
                    startFound = true;
                }
            } else {
                startFound = true;
            }
            if (end - 1 > start && nums[end - 1] > nums[start]) {
                if (nums[end - 1] <= nums[end]) {
                    end--;
                } else {
                    endFound = true;
                }
            } else {
                endFound = true;
            }
            if (startFound && endFound) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
                return end - start + 1;
            }
        }
        return 0;
    }

    public int findSmallestUnsortedV1(int[] nums) {
        int start = 0, end = nums.length - 1, gStart = 0;
        if (nums[start] > nums[end]) {
            return end - start + 1;
        }
        start = 0;
        end = 0;
        boolean startFound = false, endFound = false;
        while (start < end) {
            if (nums[start] < nums[end + 1]) {
                if (nums[end + 1] >= nums[end]) {
                    end++;
                } else {
                    startFound = true;
                    gStart = end;
                    break;
                }
            } else {
                startFound = true;
                gStart = start;
                break;
            }
        }
        start = nums.length - 2;
        end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end + 1]) {
                if (nums[end + 1] >= nums[end]) {
                    end++;
                } else {
                    startFound = true;
                    gStart = end;
                    break;
                }
            } else {
                startFound = true;
                gStart = start;
                break;
            }
        }
        return 0;
    }

    ////[1, 2, 5, 3, 7, 10, 9, 12]
    public int findSmallestUnsortedV2(int[] nums) {
        int n = nums.length, low = 0, high = n - 1, lowest = Integer.MAX_VALUE, highest = Integer.MIN_VALUE;
        while (low < n - 1 && nums[low + 1] >= nums[low]) {
            low++;
        }
        if (low == n - 1) {
            return 0;
        }
        while (high > 0 && nums[high] >= nums[high - 1]) {
            high--;
        }
        for (int i = low; i < high + 1; i++) {
            lowest = Math.min(lowest, nums[i]);
            highest = Math.max(highest, nums[i]);
        }
        while (low > 0 && nums[low - 1] > lowest) {
            low--;
        }
        while (high < n - 1 && nums[high + 1] < highest) {
            high++;
        }
        //  System.out.println(Arrays.toString(Arrays.copyOfRange(nums, low, high + 1)));
        return high - low + 1;
    }
}
