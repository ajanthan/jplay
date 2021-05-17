package com.github.ajanthan.jplay.algo.pattern.p6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Challenge 2
Maximum CPU Load (hard)
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
Example 1:
Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
jobs are running at the same time i.e., during the time interval (2,4).
Example 2:
Jobs: [[6,7,10], [2,4,11], [8,12,15]]
Output: 15
Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
Example 3:
Jobs: [[1,4,2], [2,4,1], [3,6,5]]
Output: 8
Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.maxCPULoad(new int[][]{ { 1, 4, 3 }, { 2, 5, 4 }, { 7, 9, 6 } }));
        System.out.println("Output: " + solution.maxCPULoad(new int[][]{ { 6, 7, 10 }, { 2, 4, 11 }, { 8, 12, 15 } }));
        System.out.println("Output: " + solution.maxCPULoad(new int[][]{ { 1, 4, 2 }, { 2, 4, 1 }, { 3, 6, 5 } }));
    }

    public int maxCPULoad(int[][] a) {
        final int start = 0, end = 1, cpu = 2;
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[start] >= o2[start] ? 1 : -1;
            }
        });
        PriorityQueue<CPUInfo> heap = new PriorityQueue<>(11, new Comparator<CPUInfo>() {
            @Override
            public int compare(CPUInfo o1, CPUInfo o2) {
                return o1.end >= o2.end ? 1 : -1;
            }
        });
        int i = 0, currentCPULoad = 0, maxCPULoad = 0;
        //[[1,4,3], [2,5,4], [7,9,6]]
        while (i < a.length) {
            while (heap.size() > 0 && heap.peek().end < a[i][start]) {
                currentCPULoad -= heap.remove().cpu;
            }
            currentCPULoad += a[i][cpu];
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
            heap.add(new CPUInfo(a[i][start], a[i][end], a[i][cpu]));
            i++;
        }
        return maxCPULoad;
    }

    class CPUInfo {
        int start;
        int end;
        int cpu;

        public CPUInfo(int start, int end, int cpu) {
            this.start = start;
            this.end = end;
            this.cpu = cpu;
        }
    }
}
