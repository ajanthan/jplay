package com.github.ajanthan.problems.p1;

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
    public void twoSum() {
        int[][][] ins = { { { 2, 7, 11, 15 }, { 9 } },
                          { { 3, 2, 4 }, { 6 } },
                          { { 3, 3 }, { 6 } },
                          { { 1, 2, 3, 4, 5, 6 }, { 11 } }
        };
        int[][] ans = { { 0, 1 }, { 1, 2 }, { 0, 1 }, { 4, 5 } };
        int[] ret;
        for (int i = 0; i < ins.length; i++) {
            ret = solution.twoSum(ins[i][0], ins[i][1][0]);
            Assert.assertArrayEquals(ans[i], ret);
        }
    }
}