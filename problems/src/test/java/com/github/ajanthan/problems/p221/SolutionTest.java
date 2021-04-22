package com.github.ajanthan.problems.p221;

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
    public void maximalSquareV0() {
        char[][][] ins = { { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } },
                           { { '0', '1' }, { '1', '0' } },
                           { { '0' } } };
        int[] ans = { 4, 1, 0 };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.maximalSquareV0(ins[i]));
        }
    }
}