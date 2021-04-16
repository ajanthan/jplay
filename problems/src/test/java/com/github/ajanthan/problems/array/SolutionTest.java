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
            Assert.assertEquals(ans[i], solution.singleNumberV0(ins[i]));
            Assert.assertEquals(ans[i], solution.singleNumberV1(ins[i]));
            Assert.assertEquals(ans[i], solution.singleNumberV2(ins[i]));
            Assert.assertEquals(ans[i], solution.singleNumberV3(ins[i]));
            Assert.assertEquals(ans[i], solution.singleNumberV4(ins[i]));
        }
    }

    @Test
    public void majorityElement() {
        int[][] ins = { { 3, 2, 3 }, { 2, 2, 1, 1, 1, 2, 2 } };
        int[] ans = { 3, 2 };

        for (int i = 0; i < ans.length; i++) {
            Assert.assertEquals(ans[i], solution.majorityElementV0(ins[i]));
            Assert.assertEquals(ans[i], solution.majorityElementV1(ins[i]));
            Assert.assertEquals(ans[i], solution.majorityElementV2(ins[i]));
            Assert.assertEquals(ans[i], solution.majorityElementV3(ins[i]));
        }
    }
}