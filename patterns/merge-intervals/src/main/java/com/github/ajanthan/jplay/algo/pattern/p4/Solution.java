package com.github.ajanthan.jplay.algo.pattern.p4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
Problem Statement
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Example 1:

Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.

Example 2:

Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.

Example 3:

Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.canAttendAllV1(new int[][]{ { 1, 4 }, { 2, 5 }, { 7, 9 } }));
        System.out.println("Output: " + solution.canAttendAllV1(new int[][]{ { 6, 7 }, { 2, 4 }, { 8, 12 } }));
        System.out.println("Output: " + solution.canAttendAllV1(new int[][]{ { 4, 5 }, { 2, 3 }, { 3, 6 } }));

        System.out.println("Output: " + solution.canAttendAllV2(new int[][]{ { 1, 4 }, { 2, 5 }, { 7, 9 } }));
        System.out.println("Output: " + solution.canAttendAllV2(new int[][]{ { 6, 7 }, { 2, 4 }, { 8, 12 } }));
        System.out.println("Output: " + solution.canAttendAllV2(new int[][]{ { 4, 5 }, { 2, 3 }, { 3, 6 } }));
    }

    public boolean canAttendAllV1(int[][] a) {
        int start = 0, end = 1;
        Map<Integer, Boolean> cal = new HashMap<>();
        for (int[] inv : a) {
            if ((cal.get(inv[start]) != null && cal.get(inv[start]))
                || (cal.get(inv[end]) != null && cal.get(inv[end]))) return false;

            for (int i = inv[start]; i <= inv[end]; i++) {
                cal.put(i, true);
            }
        }
        return true;
    }

    public boolean canAttendAllV2(int[][] a) {
        final int start = 0, end = 1;
        int i = 0;
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[start] >= o2[start] ? 1 : -1;
            }
        });
        while (i < a.length - 1) {
            //     ######
            //#######
            if (a[i][start] >= a[i + 1][start] && a[i][start] <= a[i + 1][end]) {
                return false;
            }
            //######
            //   ######
            if (a[i][start] <= a[i + 1][start] && a[i][end] >= a[i + 1][start]) {
                return false;
            }
            i++;
        }
        return true;
    }

}
