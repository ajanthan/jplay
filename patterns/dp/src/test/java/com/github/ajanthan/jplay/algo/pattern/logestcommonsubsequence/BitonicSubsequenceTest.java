package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class BitonicSubsequenceTest extends TestCase {
    private BitonicSubsequence bitonicSubsequence;

    public void setUp() throws Exception {
        super.setUp();
        bitonicSubsequence = new BitonicSubsequence();
    }

    public void testGetMaxLength() {
        Assert.assertEquals(6, bitonicSubsequence.getMaxLength(new int[]{ 1, 11, 2, 10, 4, 5, 2, 1 }));
        Assert.assertEquals(5, bitonicSubsequence.getMaxLength(new int[]{ 12, 11, 40, 5, 3, 1 }));
        Assert.assertEquals(5, bitonicSubsequence.getMaxLength(new int[]{ 80, 60, 30, 40, 20, 10 }));
    }
}