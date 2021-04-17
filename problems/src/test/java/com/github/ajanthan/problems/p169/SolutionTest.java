package com.github.ajanthan.problems.p169;

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
    public void majorityElement() {
        int[][] ins = { { 3, 2, 3 }, { 2, 2, 1, 1, 1, 2, 2 }, { 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2 } };
        int[] ans = { 3, 2, 1 };

        for (int i = 0; i < ans.length; i++) {
            Assert.assertEquals(ans[i], solution.majorityElementV0(ins[i]));
            Assert.assertEquals(ans[i], solution.majorityElementV1(ins[i]));
            Assert.assertEquals(ans[i], solution.majorityElementV2(ins[i]));
            Assert.assertEquals(ans[i], solution.majorityElementV3(ins[i]));
        }
    }
}