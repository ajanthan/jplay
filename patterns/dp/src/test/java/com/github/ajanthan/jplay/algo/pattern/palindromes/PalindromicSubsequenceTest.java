package com.github.ajanthan.jplay.algo.pattern.palindromes;

import junit.framework.TestCase;
import org.junit.Assert;

public class PalindromicSubsequenceTest extends TestCase {
    private PalindromicSubsequence palindromicSubsequence;

    public void setUp() throws Exception {
        super.setUp();
        palindromicSubsequence = new PalindromicSubsequence();
    }

    public void testGetLongestPalindromicSubsequenceV0() {
        Assert.assertEquals(4, palindromicSubsequence.getLongestPalindromicSubsequenceV0("bbbab"));
        Assert.assertEquals(2, palindromicSubsequence.getLongestPalindromicSubsequenceV0("cbbd"));
        Assert.assertEquals(1, palindromicSubsequence.getLongestPalindromicSubsequenceV0("abc"));
    }

    public void testGetLongestPalindromicSubsequenceV1() {
        Assert.assertEquals(4, palindromicSubsequence.getLongestPalindromicSubsequenceV1("bbbab"));
        Assert.assertEquals(2, palindromicSubsequence.getLongestPalindromicSubsequenceV1("cbbd"));
        Assert.assertEquals(1, palindromicSubsequence.getLongestPalindromicSubsequenceV1("abc"));
    }
}