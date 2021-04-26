package com.github.ajanthan.problems.p26;

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
    public void removeDuplicates() {
        int[][] ins = { { 1, 1, 2 }, { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }, {}, { 1, 1, 2, 2, 3, 3, 3 }, { 1, 2, 3, 4 } };
        int[][] ans = { { 1, 2 }, { 0, 1, 2, 3, 4 }, {}, { 1, 2, 3 }, { 1, 2, 3, 4 } };

        for (int i = 0; i < ins.length; i++) {
            int l = solution.removeDuplicates(ins[i]);
            for (int j = 0; j < l; j++) {
                Assert.assertEquals(ans[i][j], ins[i][j]);
            }
        }
    }
}