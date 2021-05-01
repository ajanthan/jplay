package com.github.ajanthan.sorting;

import junit.framework.TestCase;
import org.junit.Assert;

public class SorterTest extends TestCase {
    int[][] ins = { { 2, 3, 4, 5, 1 }, { -1, 2, 0, 3, 4 }, { -1, -2, 0, 2, 1 }, { -1, -2, 1, 2, 0 }, { 1, 1, 1, 1 } };
    int[][] ans = { { 1, 2, 3, 4, 5 }, { -1, 0, 2, 3, 4 }, { -2, -1, 0, 1, 2 }, { -2, -1, 0, 1, 2 }, { 1, 1, 1, 1 } };

    public void testMergeSort() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertArrayEquals(ans[i], Sorter.MergeSort(ins[i]));
        }
    }

    public void testBubbleSort() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertArrayEquals(ans[i], Sorter.BubbleSort(ins[i]));
        }
    }

    public void testQuickSort() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertArrayEquals(ans[i], Sorter.QuickSort(ins[i]));
        }
    }

    public void testSelectionSort() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertArrayEquals(ans[i], Sorter.SelectionSort(ins[i]));
        }
    }
}