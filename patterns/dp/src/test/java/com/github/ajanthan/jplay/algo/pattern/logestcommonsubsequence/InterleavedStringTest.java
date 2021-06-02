package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class InterleavedStringTest extends TestCase {
    private InterleavedString interleavedString;

    public void setUp() throws Exception {
        super.setUp();
        interleavedString = new InterleavedString();
    }

    public void testIsInterleavedV0() {
        Assert.assertTrue(interleavedString.isInterleavedV0("XXY", "XXZ", "XXXXZY"));
        Assert.assertFalse(interleavedString.isInterleavedV0("YX", "X", "XXY"));
    }
}