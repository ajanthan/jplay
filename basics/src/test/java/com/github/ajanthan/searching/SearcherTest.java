package com.github.ajanthan.searching;

import com.github.ajanthan.sorting.Sorter;
import junit.framework.TestCase;
import org.junit.Assert;

public class SearcherTest extends TestCase {
    private int[][][] ins = { { { 1, 2, 3, 4, 5, 6 }, { 4 } }, { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 0 } }, { { 1, 9, 5, 6, 7, 3, 4, 5, 5, 7, 8, 4 }, { 4 } } };
    private int[][] ans = { { 3 }, { -1 }, { 6, 11 } };

    public void testLinearSearch() {
        for (int i = 0; i < ins.length; i++) {
            int index = Searcher.LinearSearch(ins[i][0], ins[i][1][0]);
            Assert.assertTrue(ans[i][0] == index || (ans[i].length > 1 && ans[i][1] == index));
        }
    }

    public void testBinarySearch() {
        for (int i = 0; i < ins.length; i++) {
            int index = Searcher.BinarySearch(Sorter.QuickSort(ins[i][0]), ins[i][1][0]);
            Assert.assertTrue(ans[i][0] == index || (ans[i].length > 1 && ans[i][1] == index));
        }
    }
}