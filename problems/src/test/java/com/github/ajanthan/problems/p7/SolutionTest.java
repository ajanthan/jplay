package com.github.ajanthan.problems.p7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    private int[] ins;
    private int[] ans;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
        ins = new int[]{ 123,
                         -123,
                         120,
                         0,
                         -2147483412,
                         463847412,
                         1463847412,
                         1534236469 };
        ans = new int[]{ 321,
                         -321,
                         21,
                         0,
                         -2143847412,
                         214748364,
                         2147483641,
                         0 };
    }

    @Test
    public void reverse() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.reverse(ins[i]));
        }
    }
}