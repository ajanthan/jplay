package com.github.ajanthan.searching;

import junit.framework.TestCase;
import org.junit.Assert;

public class SearcherTest extends TestCase {
    private int[][][] ins = { { { 1, 2, 3, 4, 5, 6 }, { 4 } }, { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 0 } }, { { 1, 3, 4, 4, 5, 5, 5, 6, 7, 7, 8, 9 }, { 4 } } };
    private int[][] ans = { { 3 }, { -1 }, { 2, 3 } };

    public void testLinearSearch() {
        for (int i = 0; i < ins.length; i++) {
            int index = Searcher.LinearSearch(ins[i][0], ins[i][1][0]);
            Assert.assertTrue(ans[i][0] == index || (ans[i].length > 1 && ans[i][1] == index));
        }
    }

    public void testBinarySearch() {
        for (int i = 0; i < ins.length; i++) {
            int index = Searcher.BinarySearch(ins[i][0], ins[i][1][0]);
            Assert.assertTrue(ans[i][0] == index || (ans[i].length > 1 && ans[i][1] == index));
        }
    }

    public void testFindFirst() {
        int first = Searcher.FindFirst(ins[2][0], 5);
        Assert.assertEquals(4, first);
    }

    public void testFindLast() {
        int last = Searcher.FindLast(ins[2][0], 5);
        Assert.assertEquals(6, last);
    }
}