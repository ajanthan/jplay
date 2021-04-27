package com.github.ajanthan.problems.p497;

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
    public void findTargetSumWaysV0() {
        int[][][] ins = { { { 1, 1, 1, 1, 1 }, { 3 } },
                          { { 1 }, { 1 } },
                          { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0 } },
                          { { 1, 2, 3, 4, 5, 6 }, { 11 } }
        };
        int[] ans = { 5, 1, 1048576, 3 };
        int ret;
        for (int i = 0; i < ins.length; i++) {
            ret = solution.findTargetSumWaysV0(ins[i][0], ins[i][1][0]);
            Assert.assertEquals(ans[i], ret);
        }
    }
}