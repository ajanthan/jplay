package com.github.ajanthan.problems.p9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void isPalindrome() {
        int[] ins = { 121, -121, 10, -101, 100100, 123321 };
        boolean[] ans = { true, false, false, false, false, true };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertTrue(solution.isPalindromeV1(ins[i]) == ans[i]);
        }
    }

    @Test
    public void isPalindromeV2() {
        int[] ins = { 121, -121, 10, -101, 100100, 123321 };
        boolean[] ans = { true, false, false, false, false, true };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertTrue(solution.isPalindromeV2(ins[i]) == ans[i]);
        }
    }

    @Test
    public void isPalindromeV3() {
        int[] ins = { 121, -121, 10, -101, 100100, 123321 };
        boolean[] ans = { true, false, false, false, false, true };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertTrue(solution.isPalindromeV3(ins[i]) == ans[i]);
        }
    }
}