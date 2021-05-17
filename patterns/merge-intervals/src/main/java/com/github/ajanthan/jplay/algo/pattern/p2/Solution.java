package com.github.ajanthan.jplay.algo.pattern.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct
position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

Example 1:
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

Example 2:
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
Output: [[1,3], [4,12]]
Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].

Example 3:
Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
Output: [[1,4], [5,7]]
Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].

 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals1 = { { 1, 3 }, { 5, 7 }, { 8, 12 } };
        int[][] intervals2 = { { 1, 3 }, { 5, 7 }, { 8, 12 } };
        int[][] intervals3 = { { 2, 3 }, { 5, 7 } };
        int[][] intervals4 = { { 3, 4 }, { 5, 7 } };
        System.out.println("Output: " + solution.getMergedInterval(intervals1, new int[]{ 4, 6 }));
        System.out.println("Output: " + solution.getMergedInterval(intervals2, new int[]{ 4, 10 }));
        System.out.println("Output: " + solution.getMergedInterval(intervals3, new int[]{ 1, 4 }));
        System.out.println("Output: " + solution.getMergedInterval(intervals4, new int[]{ 1, 2 }));
        System.out.println("Output: " + solution.getMergedInterval(intervals4, new int[]{ 1, 3 }));
        System.out.println("Output: " + solution.getMergedInterval(intervals4, new int[]{ 7, 8 }));
        System.out.println("Output: " + solution.getMergedInterval(intervals4, new int[]{ 8, 9 }));
    }

    public List<List<Integer>> getMergedInterval(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isMerged = false;
        for (int[] oldInterval : intervals) {
            if (!isMerged) {
                if (oldInterval[0] < newInterval[0]) {
                    if (oldInterval[1] < newInterval[0]) {
                        result.add(Arrays.asList(oldInterval[0], oldInterval[1]));
                    } else {
                        newInterval[0] = oldInterval[0];
                        if (oldInterval[1] > newInterval[1]) {
                            newInterval[1] = oldInterval[1];
                        }
                    }
                } else {
                    if (oldInterval[0] > newInterval[1]) {
                        result.add(Arrays.asList(newInterval[0], newInterval[1]));
                        result.add(Arrays.asList(oldInterval[0], oldInterval[1]));
                        isMerged = true;
                    } else {
                        if (oldInterval[1] > newInterval[1]) {
                            newInterval[1] = oldInterval[1];
                        }
                    }
                }
            } else {
                result.add(Arrays.asList(oldInterval[0], oldInterval[1]));
            }
        }
        if (!isMerged) result.add(Arrays.asList(newInterval[0], newInterval[1]));
        return result;
    }

    public List<List<Integer>> getMergedIntervalV0(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, start = 0, end = 1;
        while (i < intervals.length && intervals[i][end] < newInterval[start]) {
            result.add(Arrays.asList(intervals[i][start], intervals[i][end]));
            i++;
        }
        while (i < intervals.length && intervals[i][end] <= newInterval[start] && intervals[i][start] <= newInterval[end]) {
            newInterval[start] = Math.min(intervals[i][start], newInterval[start]);
            newInterval[end] = Math.min(intervals[i][end], newInterval[end]);
            result.add(Arrays.asList(newInterval[start], newInterval[end]));
        }
        while (i < intervals.length) {
            result.add(Arrays.asList(intervals[i][start], intervals[i][end]));
            i++;
        }
        return result;
    }
}
