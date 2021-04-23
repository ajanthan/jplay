package com.github.ajanthan.problems.p53;

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
    public void maxSubArray() {
        int[][] ins = { { -2, 1, -3, 4, -1, 2, 1, -5, 4 },
                        { 1 },
                        { 5, 4, -1, 7, 8 },
                        { -1, -2 },
                        { -2, -1 },
                        { 1, 2 } };
        int[] ans = { 6, 1, 23, -1, -1, 3 };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.maxSubArrayV0(ins[i]));
            Assert.assertEquals(ans[i], solution.maxSubArrayV1(ins[i]));
        }
    }
}