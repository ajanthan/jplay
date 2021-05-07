package com.github.ajanthan.arrays;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class TwoSumTest extends TestCase {
    private TwoSum twoSum;

    public void setUp() throws Exception {
        super.setUp();
        twoSum = new TwoSum();
    }

    public void testTwoSumBF() {
        int[][][] ins = { { { 1, 2, 3, 4, 5, 9, 8 }, { 8 } }, { { 4, 2, 3, 4, 4, 5, 5 }, { 5 } }, { { 1, 2, 1, 3, 5, 2, 6 }, { 10 } }, { { 1 }, { 1 } } };
        int[][] ans = { { 2, 4 }, { 1, 2 }, {}, {} };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertArrayEquals(String.format("TwoSumBF case %d", i), ans[i], twoSum.twoSumBF(ins[i][0], ins[i][1][0]));
        }
    }

    public void testTwoSumHT() {
        int[][][] ins = { { { 1, 2, 3, 4, 5, 9, 8 }, { 8 } }, { { 4, 2, 3, 4, 4, 5, 5 }, { 5 } }, { { 1, 2, 1, 3, 5, 2, 6 }, { 10 } }, { { 1 }, { 1 } } };
        int[][] ans = { { 2, 4 }, { 1, 2 }, {}, {} };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertArrayEquals(String.format("TwoSumBF case %d", i), ans[i], twoSum.twoSumHT(ins[i][0], ins[i][1][0]));
        }
    }

    public void testTwoSumHTV1() {
        int[][][] ins = { { { 1, 2, 3, 4, 5, 9, 8 }, { 8 } }, { { 4, 2, 3, 4, 4, 5, 5 }, { 5 } }, { { 1, 2, 1, 3, 5, 2, 6 }, { 10 } }, { { 1 }, { 1 } } };
        int[][] ans = { { 4, 2 }, { 2, 1 }, {}, {} };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertArrayEquals(String.format("TwoSumBF case %d", i), ans[i], twoSum.twoSumHTV1(ins[i][0], ins[i][1][0]));
        }
    }

    public void testTwoSumHTSorted() {
        int[][][] ins = { { { 1, 2, 3, 4, 5, 9, 8 }, { 8 } }, { { 4, 2, 3, 4, 4, 5, 5 }, { 5 } }, { { 1, 2, 1, 3, 5, 2, 6 }, { 10 } }, { { 1 }, { 1 } } };
        int[][] ans = { { 2, 4 }, { 1, 2 }, {}, {} };
        for (int i = 0; i < ins.length; i++) {
            Arrays.sort(ins[i][0]);
            int[] r = twoSum.twoSumHTSorted(ins[i][0], ins[i][1][0]);
            if (ans[i].length != 0) {
                Assert.assertTrue(String.format("TwoSumBF case %d", i), ins[i][1][0] == (ins[i][0][r[0]] + ins[i][0][r[1]]));
            } else {
                Assert.assertTrue(String.format("TwoSumBF case %d", i), r.length == 0);
            }

        }
    }
}