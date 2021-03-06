package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestCommonSubsequenceTest extends TestCase {
    private LongestCommonSubsequence lcs;

    public void setUp() throws Exception {
        super.setUp();
        lcs = new LongestCommonSubsequence();
    }

    public void testGetLongestCommonSubsequenceV0() {
        Assert.assertEquals(3, lcs.getLongestCommonSubsequenceV0("abcde", "ace"));
        Assert.assertEquals(3, lcs.getLongestCommonSubsequenceV0("abc", "abc"));
        Assert.assertEquals(0, lcs.getLongestCommonSubsequenceV0("abc", "def"));
    }

    public void testGetLongestCommonSubsequenceV1() {
        Assert.assertEquals(3, lcs.getLongestCommonSubsequenceV1("abcde", "ace"));
        Assert.assertEquals(3, lcs.getLongestCommonSubsequenceV1("abc", "abc"));
        Assert.assertEquals(0, lcs.getLongestCommonSubsequenceV1("abc", "def"));
    }
}