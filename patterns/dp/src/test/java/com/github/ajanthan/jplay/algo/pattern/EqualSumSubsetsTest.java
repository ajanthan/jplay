package com.github.ajanthan.jplay.algo.pattern;

import junit.framework.TestCase;
import org.junit.Assert;

public class EqualSumSubsetsTest extends TestCase {
    private EqualSumSubsets equalSumSubsets;

    public void setUp() throws Exception {
        super.setUp();
        equalSumSubsets = new EqualSumSubsets();
    }

    public void testHasEqualSumSubsetV0() {
        Assert.assertTrue(equalSumSubsets.hasEqualSumSubsetV0(new int[]{ 1, 2, 3, 4 }));
        Assert.assertFalse(equalSumSubsets.hasEqualSumSubsetV0(new int[]{ 2, 2, 6, 4 }));
        Assert.assertFalse(equalSumSubsets.hasEqualSumSubsetV0(new int[]{ 1, 2, 4, 6 }));
    }

    public void testHasEqualSumSubsetV1() {
        Assert.assertTrue(equalSumSubsets.hasEqualSumSubsetV1(new int[]{ 1, 2, 3, 4 }));
        Assert.assertFalse(equalSumSubsets.hasEqualSumSubsetV1(new int[]{ 2, 2, 6, 4 }));
        Assert.assertFalse(equalSumSubsets.hasEqualSumSubsetV1(new int[]{ 1, 2, 4, 6 }));
    }

    public void testHasEqualSumSubsetV2() {
        Assert.assertTrue(equalSumSubsets.hasEqualSumSubsetV2(new int[]{ 1, 2, 3, 4 }));
        Assert.assertFalse(equalSumSubsets.hasEqualSumSubsetV2(new int[]{ 2, 2, 6, 4 }));
        Assert.assertFalse(equalSumSubsets.hasEqualSumSubsetV2(new int[]{ 1, 2, 4, 6 }));
    }
}