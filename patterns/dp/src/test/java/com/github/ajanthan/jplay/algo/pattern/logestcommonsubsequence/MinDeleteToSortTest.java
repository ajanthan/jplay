package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class MinDeleteToSortTest extends TestCase {
    private MinDeleteToSort minDeleteToSort;

    public void setUp() throws Exception {
        super.setUp();
        minDeleteToSort = new MinDeleteToSort();
    }

    public void testGetNumberOfDeletions() {
        Assert.assertEquals(2, minDeleteToSort.getNumberOfDeletions(new int[]{ 5, 6, 1, 7, 4 }));
        Assert.assertEquals(4, minDeleteToSort.getNumberOfDeletions(new int[]{ 30, 40, 2, 5, 1, 7, 45, 50, 8 }));
    }
}