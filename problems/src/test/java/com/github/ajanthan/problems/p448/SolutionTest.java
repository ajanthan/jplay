package com.github.ajanthan.problems.p448;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testFindDisappearedNumbers() {
        int[][] ins = { { 4, 3, 2, 7, 8, 2, 3, 1 }, { 1, 1 } };
        int[][] ans = { { 5, 6 }, { 2 } };
        List<Integer> an;
        for (int i = 0; i < ins.length; i++) {
            an = solution.findDisappearedNumbersV1(ins[i]);
            for (int j : ans[i]) {
                Assert.assertTrue(an.contains(j));
            }
        }
    }

    @Test
    public void findDisappearedNumbersV2() {
        int[][] ins = { { 4, 3, 2, 7, 8, 2, 3, 1 }, { 1, 1 } };
        int[][] ans = { { 5, 6 }, { 2 } };
        List<Integer> an;
        for (int i = 0; i < ins.length; i++) {
            an = solution.findDisappearedNumbersV2(ins[i]);
            for (int j : ans[i]) {
                Assert.assertTrue(an.contains(j));
            }
        }
    }
}