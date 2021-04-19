package com.github.ajanthan.problems.p13;

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
    public void romanToIntV0() {
        String[] ins = { "III", "IV", "IX", "LVIII", "MCMXCIV" };
        int[] ans = { 3, 4, 9, 58, 1994 };

        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.romanToIntV0(ins[i]));
        }
    }
    @Test
    public void romanToIntV1() {
        String[] ins = { "III", "IV", "IX", "LVIII", "MCMXCIV" };
        int[] ans = { 3, 4, 9, 58, 1994 };

        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.romanToIntV1(ins[i]));
        }
    }
}