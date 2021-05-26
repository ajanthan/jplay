package com.github.ajanthan.jplay.algo.pattern;

import junit.framework.TestCase;
import org.junit.Assert;

public class PalindromicPartitionTest extends TestCase {
    private PalindromicPartition palindromicPartition;

    public void setUp() throws Exception {
        super.setUp();
        palindromicPartition = new PalindromicPartition();
    }

    public void testMinCutV0() {
        Assert.assertEquals(2, palindromicPartition.minCutV0("geek"));
        Assert.assertEquals(3, palindromicPartition.minCutV0("ababbbabbababa"));
    }
}