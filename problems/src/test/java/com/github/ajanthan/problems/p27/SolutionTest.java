package com.github.ajanthan.problems.p27;

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
    public void removeElementV1() {
        int[][] numss = { { 3, 2, 2, 3 }, { 0, 1, 2, 2, 3, 0, 4, 2 }, {}, { 1, 2, 2, 2, 2, 3, 3, 1 } };
        int[] vals = { 3, 2, 1, 2 };
        int length;
        for (int i = 0; i < numss.length; i++) {
            length = solution.removeElementV1(numss[i], vals[i]);
            for (int j = 0; j < length; j++) {
                Assert.assertTrue(numss[i][j] != vals[i]);
            }
        }
    }

    @Test
    public void removeElementV2() {
        int[][] numss = { { 3, 2, 2, 3 }, { 0, 1, 2, 2, 3, 0, 4, 2 }, {}, { 1, 2, 2, 2, 2, 3, 3, 1 } };
        int[] vals = { 3, 2, 1, 2 };
        int length;
        for (int i = 0; i < numss.length; i++) {
            length = solution.removeElementV2(numss[i], vals[i]);
            for (int j = 0; j < length; j++) {
                Assert.assertTrue(numss[i][j] != vals[i]);
            }
        }
    }
}