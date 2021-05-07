package com.github.ajanthan.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //time: O(N^2)
    //space: O(1)
    public int[] twoSumBF(int[] in, int targetSum) {
        for (int i = 0; i < in.length; i++) {
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] == targetSum - in[i]) {
                    return new int[]{ i, j };
                }
            }
        }
        return new int[]{};
    }

    //time: O(N)
    //space: O(N)
    public int[] twoSumHT(int[] in, int targetSum) {
        Map<Integer, Integer> ht = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            ht.put(in[i], i);
        }
        for (int i = 0; i < in.length; i++) {
            if (ht.containsKey(targetSum - in[i])) {
                int index = ht.get(targetSum - in[i]);
                if (index != i) {
                    return new int[]{ i, index };
                }
            }
        }
        return new int[]{};
    }

    //time: O(N)
    //space: O(N)
    public int[] twoSumHTV1(int[] in, int targetSum) {
        Map<Integer, Integer> ht = new HashMap<>();

        for (int i = 0; i < in.length; i++) {
            if (ht.containsKey(targetSum - in[i])) {
                return new int[]{ i, ht.get(targetSum - in[i]) };
            }
            ht.put(in[i], i);
        }
        return new int[]{};
    }
    //time: O(N)
    //space: O(1)
    public int[] twoSumHTSorted(int[] in, int targetSum) {
        int currentSum, start = 0, end = in.length - 1;
        while (start < end) {
            currentSum = in[start] + in[end];
            if (currentSum == targetSum) {
                return new int[]{ start, end };
            } else if (currentSum < targetSum) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }
}
