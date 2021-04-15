package com.github.ajanthan.problems.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void singleNumber() {
        int[][] ins = { { 2, 2, 1 }, { 4, 1, 2, 1, 2 }, { 1 }, { 2, 2, 3, 4, 4 }, { 1, 0, 1 } };
        int[] ans = { 1, 4, 1, 3, 0 };

        for (int i = 0; i < ans.length; i++) {
            Assert.assertEquals(ans[i], solution.singleNumber(ins[i]));
        }
    }
}