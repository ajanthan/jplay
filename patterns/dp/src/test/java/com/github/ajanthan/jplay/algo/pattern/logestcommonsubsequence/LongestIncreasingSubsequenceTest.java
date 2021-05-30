package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestIncreasingSubsequenceTest extends TestCase {
    private LongestIncreasingSubsequence longestIncreasingSubsequence;

    public void setUp() throws Exception {
        super.setUp();
        longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    }

    public void testGetLengthV0() {
        Assert.assertEquals(3, longestIncreasingSubsequence.getLengthV0(new int[]{ 3, 10, 2, 1, 20 }));
        Assert.assertEquals(3, longestIncreasingSubsequence.getLengthV0(new int[]{ 4, 1, 2, 3, 0 }));
        Assert.assertEquals(1, longestIncreasingSubsequence.getLengthV0(new int[]{ 3, 2 }));
        Assert.assertEquals(4, longestIncreasingSubsequence.getLengthV0(new int[]{ 50, 3, 10, 7, 40, 80 }));
        Assert.assertEquals(5, longestIncreasingSubsequence.getLengthV0(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60 }));
    }

    public void testGetLengthV1() {
        Assert.assertEquals(3, longestIncreasingSubsequence.getLengthV1(new int[]{ 3, 10, 2, 1, 20 }));
        Assert.assertEquals(3, longestIncreasingSubsequence.getLengthV1(new int[]{ 4, 1, 2, 3, 0 }));
        Assert.assertEquals(1, longestIncreasingSubsequence.getLengthV1(new int[]{ 3, 2 }));
        Assert.assertEquals(4, longestIncreasingSubsequence.getLengthV1(new int[]{ 50, 3, 10, 7, 40, 80 }));
        Assert.assertEquals(5, longestIncreasingSubsequence.getLengthV1(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60 }));
    }

    public void testGetLengthV2() {
        Assert.assertEquals(3, longestIncreasingSubsequence.getLengthV2(new int[]{ 3, 10, 2, 1, 20 }));
        Assert.assertEquals(3, longestIncreasingSubsequence.getLengthV2(new int[]{ 4, 1, 2, 3, 0 }));
        Assert.assertEquals(1, longestIncreasingSubsequence.getLengthV2(new int[]{ 3, 2 }));
        Assert.assertEquals(4, longestIncreasingSubsequence.getLengthV2(new int[]{ 50, 3, 10, 7, 40, 80 }));
        Assert.assertEquals(5, longestIncreasingSubsequence.getLengthV2(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60 }));
    }
}