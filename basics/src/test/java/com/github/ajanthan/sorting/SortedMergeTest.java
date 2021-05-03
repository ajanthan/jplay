package com.github.ajanthan.sorting;

import junit.framework.TestCase;
import org.junit.Assert;

public class SortedMergeTest extends TestCase {
    private SortedMerge sortedMerge;

    public void setUp() throws Exception {
        super.setUp();
        sortedMerge = new SortedMerge();
    }

    public void testMergeV0() {
        int[] a = new int[10];
        int i = 0;
        for (int n : new int[]{ 2, 4, 6, 8, 10 }) {
            a[i++] = n;
        }
        int[] b = { 1, 3, 5, 7, 9 };
        sortedMerge.mergeV0(a, 5, b);
        Assert.assertArrayEquals(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, a);
    }

    public void testMergeV1() {
        int[] a = new int[10];
        int i = 0;
        for (int n : new int[]{ 2, 4, 6, 8, 10 }) {
            a[i++] = n;
        }
        int[] b = { 1, 3, 5, 7, 9 };
        sortedMerge.mergeV1(a, 5, b);
        Assert.assertArrayEquals(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, a);
    }

    public void testMergeV2() {
        int[] a = new int[10];
        int i = 0;
        for (int n : new int[]{ 2, 4, 6, 8, 10 }) {
            a[i++] = n;
        }
        int[] b = { 1, 3, 5, 7, 9 };
        sortedMerge.mergeV2(a, 5, b);
        Assert.assertArrayEquals(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, a);
    }
}