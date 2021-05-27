package com.github.ajanthan.jplay.algo.pattern.zerooneknapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers and a sum, the task is to print all subsets of the given array with a sum equal
 * to a given sum.
 * Examples:
 * <p>
 * Input : arr[] = {2, 3, 5, 6, 8, 10}
 * sum = 10
 * Output : 5 2 3
 * 2 8
 * 10
 * <p>
 * Input : arr[] = {1, 2, 3, 4, 5}
 * sum = 10
 * Output : 4 3 2 1
 * 5 3 2
 * 5 4 1
 */
public class PerfectSum {
    public static void main(String[] args) {
        PerfectSum perfectSum = new PerfectSum();
        System.out.println(perfectSum.getSubsetSumV0(new int[]{ 2, 3, 5, 6, 8, 10 }, 10));
        //System.out.println(perfectSum.getSubsetSumV1(new int[]{ 1,2,3,4 }, 6));
    }

    public List<List<Integer>> getSubsetSumV0(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsetSumRecursively(nums, target, 0, result, new ArrayList<Integer>());
        return result;
    }

    private void getSubsetSumRecursively(int[] nums, int target, int i, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if (i >= nums.length) {
            return;
        }
        getSubsetSumRecursively(nums, target, i + 1, result, current);
        if (target >= nums[i]) {
            current.add(nums[i]);
            getSubsetSumRecursively(nums, target - nums[i], i + 1, result, current);
            current.remove((Integer) nums[i]);
        }
    }

//    public List<List<Integer>> getSubsetSumV1(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        boolean[][] dp = new boolean[nums.length][target + 1];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i][0] = true;
//        }
//
//        if (nums[0] <= target) {
//            dp[0][nums[0]] = true;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 1; j <= target; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j >= nums[i]) {
//                    if (dp[i - 1][j - nums[i]]) {
//                        dp[i][j] = true;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//            if (dp[i][target]) {
//                List<Integer> temp = new ArrayList<>();
//                int sum = target;
//                int j = i - 1;
//                if(!dp[j][target] && dp[j][target-nums[j+1]]) {
//                    temp.add(nums[i]);
//                    sum=sum-nums[j+1];
//                }
//                while (sum > 0 && j >= 0) {
//                    if (dp[j][sum]) {
//                        temp.add(nums[j]);
//                        sum = sum - nums[j];
//                    }
//                    j--;
//                }
//                result.add(temp);
//            }
//        }
//        return result;
//    }
}
