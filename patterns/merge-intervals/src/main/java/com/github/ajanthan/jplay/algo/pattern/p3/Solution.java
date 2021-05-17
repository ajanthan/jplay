package com.github.ajanthan.jplay.algo.pattern.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals
sorted on their start time.
Example 1:
Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.
Example 2:
Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
Explanation: The output list contains the common intervals between the two lists.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getIntersections(new int[][]{ { 1, 3 }, { 5, 6 }, { 7, 9 } }, new int[][]{ { 2, 3 }, { 5, 7 } }));
        System.out.println("Output: " + solution.getIntersections(new int[][]{ { 1, 3 }, { 5, 7 }, { 9, 12 } }, new int[][]{ { 5, 10 } }));

        System.out.println("Output: " + solution.merge(new int[][]{ { 1, 3 }, { 5, 6 }, { 7, 9 } }, new int[][]{ { 2, 3 }, { 5, 7 } }));
        System.out.println("Output: " + solution.merge(new int[][]{ { 1, 3 }, { 5, 7 }, { 9, 12 } }, new int[][]{ { 5, 10 } }));
    }

    public List<List<Integer>> getIntersections(int[][] l1, int[][] l2) {
        List<List<Integer>> result = new ArrayList<>();
        int i1 = 0, i2 = 0, start = 0, end = 1, newStart, newEnd;

        while (i1 < l1.length && i2 < l2.length) {
            while (i1 < l1.length && i2 < l2.length && l1[i1][start] > l2[i2][end]) {
                i2++;
            }
            while (i1 < l1.length && i2 < l2.length && l2[i2][start] > l1[i1][end]) {
                i1++;
            }
            if (l1[i1][start] <= l2[i2][end] || l1[i1][end] >= l2[i2][start]) {
                if (l1[i1][start] > l2[i2][start]) {
                    newStart = l1[i1][start];
                } else {
                    newStart = l2[i2][start];
                }
                if (l1[i1][end] < l2[i2][end]) {
                    newEnd = l1[i1][end];
                    i1++;
                } else {
                    newEnd = l2[i2][end];
                    i2++;
                }
                result.add(Arrays.asList(newStart, newEnd));

            }

        }
        return result;
    }

    public List<List<Integer>> merge(int[][] l1, int[][] l2) {
        //l1#start######end
        //      l2#start######end
        //      l1#start######end
        //l2#start######end
        List<List<Integer>> result = new ArrayList<>();
        int i1 = 0, i2 = 0, start = 0, end = 1;
        while (i1 < l1.length && i2 < l2.length) {
            //arr1=[[1, 3], [5, 7], [9, 12]],
            //arr2=[[5, 10]]
            if ((l1[i1][start] <= l2[i2][start] && l1[i1][end] >= l2[i2][start]) ||
                (l1[i1][start] >= l2[i2][start] && l1[i1][start] <= l2[i2][end])) {
                result.add(Arrays.asList(Math.max(l1[i1][start], l2[i2][start]), Math.min(l1[i1][end], l2[i2][end])));
            }
            if (l1[i1][end] > l2[i2][end]) {
                i2++;
            } else {
                i1++;
            }
        }
        return result;
    }
}
