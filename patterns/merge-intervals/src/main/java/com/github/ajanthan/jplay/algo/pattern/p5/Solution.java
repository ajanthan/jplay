package com.github.ajanthan.jplay.algo.pattern.p5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Solution Review: Problem Challenge 1 - Minimum Meeting Rooms (hard)
Given a list of intervals representing the start and end time of ‘N’ meetings,
find the minimum number of rooms required to hold all the meetings.
Example 1:
Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
occur in any of the two rooms later.
Example 2:
Meetings: [[6,7], [2,4], [8,12]]
Output: 1
Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
Example 3:
Meetings: [[1,4], [2,3], [3,6]]
Output:2
Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
hold all the meetings.

Example 4:
Meetings: [[4,5], [2,3], [2,4], [3,5]]
Output: 2
Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].

Here is a visual representation of Example 4:
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV1(new int[][]{ { 1, 4 }, { 2, 5 }, { 7, 9 } }));
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV1(new int[][]{ { 6, 7 }, { 2, 4 }, { 8, 12 } }));
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV1(new int[][]{ { 1, 4 }, { 2, 3 }, { 3, 6 } }));
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV1(new int[][]{ { 4, 5 }, { 2, 3 }, { 2, 4 }, { 3, 5 } }));
        System.out.println();
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV2(new int[][]{ { 1, 4 }, { 2, 5 }, { 7, 9 } }));
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV2(new int[][]{ { 6, 7 }, { 2, 4 }, { 8, 12 } }));
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV2(new int[][]{ { 1, 4 }, { 2, 3 }, { 3, 6 } }));
        System.out.println("Output: " + solution.findMinimumNumberOfRoomsV2(new int[][]{ { 4, 5 }, { 2, 3 }, { 2, 4 }, { 3, 5 } }));
    }

    public int findMinimumNumberOfRoomsV1(int[][] m) {
        final int start = 0, end = 1;
        Arrays.sort(m, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[start] >= o2[start] ? 1 : -1;
            }
        });
        int overLapStart = m[0][start], overlapEnd = m[0][end], i = 1, maXRoomCount = 1, currentRoomCount = 1;
        boolean hasOverLap = false;
        //[[1,4], [2,5], [7,9]]
        //[[2,4],[6,7],[8,12]]
        //[[1,4], [2,3], [3,6]]
        while (i < m.length) {
            //    #####
            // #####
            //#####
            //   #####
            if ((m[i][start] > overLapStart && m[i][start] < overlapEnd)
                || (m[i][start] < overLapStart && m[i][end] > overLapStart)) {
                currentRoomCount++;
                maXRoomCount = Math.max(maXRoomCount, currentRoomCount);
                overLapStart = Math.max(m[i][start], overLapStart);
                overlapEnd = Math.min(m[i][end], overlapEnd);
            } else {
                currentRoomCount = 1;
                maXRoomCount = Math.max(maXRoomCount, currentRoomCount);
                overLapStart = m[i][start];
                overlapEnd = m[i][end];
            }
            i++;
        }
        return maXRoomCount;
    }

    public int findMinimumNumberOfRoomsV2(int[][] m) {
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(10, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.end >= o2.end ? 1 : -1;
            }
        });
        final int start = 0, end = 1;
        Arrays.sort(m, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[start] >= o2[start] ? 1 : -1;
            }
        });
        //[[1,4], [2,5], [7,9]]
        //[[2,4],[6,7],[8,12]]
        //[[1,4], [2,3], [3,6]]
        int i = 0, minRoom = 0;
        while (i < m.length) {
            while (minHeap.size() > 0 && minHeap.peek().end <= m[i][start]) {
                minHeap.remove();
            }
            minHeap.add(new Meeting(m[i][start], m[i][end]));
            minRoom = Math.max(minRoom, minHeap.size());
            i++;
        }
        return minRoom;
    }

    class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

