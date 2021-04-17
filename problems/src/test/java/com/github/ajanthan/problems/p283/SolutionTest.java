package com.github.ajanthan.problems.p283;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new Solution();
    }

    @Test
    public void moveZeroesV0() {
        int[][] ins = {
            { 0, 1, 0, 3, 12 },
            { 0 },
            { 1, 2, 3, 0, 0 },
            { 0, 0, 1, 2, 3, 4 },
            { 1, 2, 3, } };
        int[] ans = { 2, 1, 2, 2, 0 };

        for (int i = 0; i < ans.length; i++) {
            solution.moveZeroesV0(ins[i]);
            for (int j = 0; j < ans[i]; j++) {
                Assert.assertEquals(0, ins[i][ins[i].length - j - 1]);
            }
        }
    }

    @Test
    public void moveZeroesV1() {
        int[][] ins = {
            { 0, 1, 0, 3, 12 },
            { 0 },
            { 1, 2, 3, 0, 0 },
            { 0, 0, 1, 2, 3, 4 },
            { 1, 2, 3, } };
        int[] ans = { 2, 1, 2, 2, 0 };

        for (int i = 0; i < ans.length; i++) {
            solution.moveZeroesV1(ins[i]);
            for (int j = 0; j < ans[i]; j++) {
                Assert.assertEquals(0, ins[i][ins[i].length - j - 1]);
            }
        }
    }

    @Test
    public void moveZeroesV2() {
        int[][] ins = {
            { 0, 1, 0, 3, 12 },
            { 0 },
            { 1, 2, 3, 0, 0 },
            { 0, 0, 1, 2, 3, 4 },
            { 1, 2, 3, } };
        int[] ans = { 2, 1, 2, 2, 0 };

        for (int i = 0; i < ans.length; i++) {
            solution.moveZeroesV2(ins[i]);
            for (int j = 0; j < ans[i]; j++) {
                Assert.assertEquals(0, ins[i][ins[i].length - j - 1]);
            }
        }
    }

    @Test
    public void moveZeroesV3() {
        int[][] ins = {
            { 0, 1, 0, 3, 12 },
            { 0 },
            { 1, 2, 3, 0, 0 },
            { 0, 0, 1, 2, 3, 4 },
            { 1, 2, 3, } };
        int[] ans = { 2, 1, 2, 2, 0 };

        for (int i = 0; i < ans.length; i++) {
            solution.moveZeroesV3(ins[i]);
            for (int j = 0; j < ans[i]; j++) {
                Assert.assertEquals(0, ins[i][ins[i].length - j - 1]);
            }
        }
    }
}