package com.github.ajanthan.jplay.algo.pattern.fibnumber;

/**
 * Given an array of integers where each element represents the max number of steps that
 * can be made forward from that element. Write a function to return the minimum number
 * of jumps to reach the end of the array (starting from the first element). If an element is 0,
 * they cannot move through that element. If the end isn’t reachable, return -1.
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 -> 9)
 * Explanation: Jump from 1st element
 * to 2nd element as there is only 1 step,
 * now there are three options 5, 8 or 9.
 * If 8 or 9 is chosen then the end node 9
 * can be reached. So 3 jumps are made.
 * <p>
 * <p>
 * Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
 * Output: 10
 * Explanation: In every step a jump
 * is needed so the count of jumps is 10.
 */
public class MinimumJump {
    public int getMinJumpsV0(int[] arr) {
        return getMinJumpsRecursively(arr, 0, 0);
    }

    private int getMinJumpsRecursively(int[] arr, int pos, int jump) {
        if (pos == arr.length - 1) {
            return jump;
        }

        int minJump = Integer.MAX_VALUE, currentJump;
        for (int i = 1; i <= arr[pos]; i++) {
            if (pos + i < arr.length) {
                currentJump = getMinJumpsRecursively(arr, pos + i, jump + 1);
                minJump = Math.min(minJump, currentJump);
            }
        }
        return minJump == Integer.MAX_VALUE ? -1 : minJump;
    }

    //{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
    public int getMinJumpsV1(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr.length;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= i - j)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[arr.length - 1] == arr.length ? -1 : dp[arr.length - 1];
    }
}
