package com.github.ajanthan.jplay.algo.pattern.zerooneknapsack;

import junit.framework.TestCase;
import org.junit.Assert;

public class SubsetSumTest extends TestCase {
    private SubsetSum subsetSum;

    public void setUp() throws Exception {
        super.setUp();
        subsetSum = new SubsetSum();
    }

    public void testHasSubsetWithSum() {
        Assert.assertTrue(subsetSum.hasSubsetWithSum(new int[]{ 3, 34, 4, 12, 5, 2 }, 9));
        Assert.assertFalse(subsetSum.hasSubsetWithSum(new int[]{ 3, 34, 4, 12, 5, 2 }, 30));
    }

    public void testGetMinimumSubsetSumDifference() {
        Assert.assertEquals(1, subsetSum.getMinimumSubsetSumDifference(new int[]{ 1, 6, 11, 5 }));
       // Assert.assertEquals(1, subsetSum.getMinimumSubsetSumDifferenceV1(new int[]{ 1, 6, 11, 5 }));
    }
}