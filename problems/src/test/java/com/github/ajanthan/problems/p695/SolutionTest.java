package com.github.ajanthan.problems.p695;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    int[][][] ins = {
        { { 0 } },
        { { 1 } },
        { { 0, 0 },
          { 0, 0 } },
        { { 1, 1 },
          { 0, 0 } },
        { { 1, 1, 1 },
          { 0, 0, 0 },
          { 1, 1, 0 } },
        { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
          { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
          { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
          { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
          { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
          { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
          { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } },
        { { 0, 0, 0, 0, 0, 0, 0, 0 } } };
    int[] ans = { 0, 1, 0, 2, 3, 6, 0 };

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void maxAreaOfIsland() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.maxAreaOfIsland(ins[i]));
        }
    }
}