package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class MaxSumIncreasingSubsequenceTest extends TestCase {
    private MaxSumIncreasingSubsequence maxSumIncreasingSubsequence;

    public void setUp() throws Exception {
        super.setUp();
        maxSumIncreasingSubsequence = new MaxSumIncreasingSubsequence();
    }

    public void testGetMaxSum() {
        Assert.assertEquals(106, maxSumIncreasingSubsequence.getMaxSum(new int[]{ 1, 101, 2, 3, 100, 4, 5 }));
        Assert.assertEquals(22, maxSumIncreasingSubsequence.getMaxSum(new int[]{ 3, 4, 5, 10 }));
        Assert.assertEquals(10, maxSumIncreasingSubsequence.getMaxSum(new int[]{ 10, 5, 4, 3 }));
    }
}