package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestAlternatingSequenceTest extends TestCase {
    private LongestAlternatingSequence longestAlternatingSequence;

    public void setUp() throws Exception {
        super.setUp();
        longestAlternatingSequence = new LongestAlternatingSequence();
    }

    public void testGetMaxLengthV0() {
        Assert.assertEquals(3, longestAlternatingSequence.getMaxLengthV0(new int[]{ 1, 5, 4 }));
        Assert.assertEquals(2, longestAlternatingSequence.getMaxLengthV0(new int[]{ 1, 4, 5 }));
        Assert.assertEquals(2, longestAlternatingSequence.getMaxLengthV0(new int[]{ 1, 4, 5, 6 }));
        Assert.assertEquals(2, longestAlternatingSequence.getMaxLengthV0(new int[]{ 5, 4, 3, 2 }));
        Assert.assertEquals(4, longestAlternatingSequence.getMaxLengthV0(new int[]{ 5, 2, 3, 2 }));
        Assert.assertEquals(6, longestAlternatingSequence.getMaxLengthV0(new int[]{ 10, 22, 9, 33, 49, 50, 31, 60 }));
    }

    public void testGetMaxLengthV1() {
        Assert.assertEquals(3, longestAlternatingSequence.getMaxLengthV1(new int[]{ 1, 5, 4 }));
        Assert.assertEquals(2, longestAlternatingSequence.getMaxLengthV1(new int[]{ 1, 4, 5 }));
        Assert.assertEquals(2, longestAlternatingSequence.getMaxLengthV1(new int[]{ 1, 4, 5, 6 }));
        Assert.assertEquals(2, longestAlternatingSequence.getMaxLengthV1(new int[]{ 5, 4, 3, 2 }));
        Assert.assertEquals(4, longestAlternatingSequence.getMaxLengthV1(new int[]{ 5, 2, 3, 2 }));
        Assert.assertEquals(6, longestAlternatingSequence.getMaxLengthV1(new int[]{ 10, 22, 9, 33, 49, 50, 31, 60 }));
    }
}