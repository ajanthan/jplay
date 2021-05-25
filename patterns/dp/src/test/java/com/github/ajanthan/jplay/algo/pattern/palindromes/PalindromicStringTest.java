package com.github.ajanthan.jplay.algo.pattern.palindromes;

import junit.framework.TestCase;
import org.junit.Assert;

public class PalindromicStringTest extends TestCase {
    private PalindromicString palindromicString;

    public void setUp() throws Exception {
        super.setUp();
        palindromicString = new PalindromicString();
    }

    public void testGetLongestSubstringV0() {
        Assert.assertEquals("geeksskeeg", palindromicString.getLongestSubstringV0("forgeeksskeegfor"));
        Assert.assertEquals("ee", palindromicString.getLongestSubstringV0("Geeks"));
        Assert.assertEquals("aba", palindromicString.getLongestSubstringV0("forabafor"));
    }

    public void testGetLongestSubstringV1() {
        Assert.assertEquals("geeksskeeg", palindromicString.getLongestSubstringV1("forgeeksskeegfor"));
        Assert.assertEquals("ee", palindromicString.getLongestSubstringV1("Geeks"));
        Assert.assertEquals("aba", palindromicString.getLongestSubstringV1("forabafor"));
    }
}