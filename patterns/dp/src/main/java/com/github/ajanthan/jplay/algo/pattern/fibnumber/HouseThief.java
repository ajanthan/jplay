package com.github.ajanthan.jplay.algo.pattern.fibnumber;

/**
 * There are n houses build in a line, each of which contains some value in it.
 * A thief is going to steal the maximal value of these houses,
 * but he can’t steal in two adjacent houses because the owner of
 * the stolen houses will tell his two neighbors left and right side.
 * What is the maximum stolen value?
 * <p>
 * Input: hval[] = {6, 7, 1, 3, 8, 2, 4}
 * Output: 19
 * Explanation: The thief will steal 6, 1, 8 and 4 from the house.
 * <p>
 * Input: hval[] = {5, 3, 4, 11, 2}
 * Output: 16
 * Explanation: Thief will steal 5 and 11
 */
public class HouseThief {
    public int getMaxValueCanBeStolen(int[] houseVal) {
        int[] dp = new int[houseVal.length];
        dp[0] = houseVal[0];
        for (int i = 1; i < houseVal.length; i++) {
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + houseVal[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], houseVal[i]);
            }
        }
        return dp[houseVal.length - 1];
    }
}
