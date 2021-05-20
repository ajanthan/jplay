package com.github.ajanthan.jplay.algo.pattern.zerooneknapsack;

import com.github.ajanthan.jplay.algo.pattern.zerooneknapsack.SubsetSum;
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
}