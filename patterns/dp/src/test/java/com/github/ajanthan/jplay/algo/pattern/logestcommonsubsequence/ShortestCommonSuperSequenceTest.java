package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class ShortestCommonSuperSequenceTest extends TestCase {
    private ShortestCommonSuperSequence shortestCommonSuperSequence;

    public void setUp() throws Exception {
        super.setUp();
        shortestCommonSuperSequence = new ShortestCommonSuperSequence();
    }

    public void testGetLength() {
        Assert.assertEquals(5, shortestCommonSuperSequence.getLength("geek", "eke"));
        Assert.assertEquals(9, shortestCommonSuperSequence.getLength("AGGTAB", "GXTXAYB"));
    }
}