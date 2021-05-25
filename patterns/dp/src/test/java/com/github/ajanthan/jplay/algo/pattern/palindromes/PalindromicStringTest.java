package com.github.ajanthan.jplay.algo.pattern.palindromes;

import com.github.ajanthan.jplay.algo.pattern.palindromes.PalindromicString;
import junit.framework.TestCase;
import org.junit.Assert;

public class PalindromicStringTest extends TestCase {
    private PalindromicString palindromicString;

    public void setUp() throws Exception {
        super.setUp();
        palindromicString = new PalindromicString();
    }

    public void testGetLongestSubstring() {
        Assert.assertEquals("geeksskeeg", palindromicString.getLongestSubstring("forgeeksskeegfor"));
        Assert.assertEquals("ee", palindromicString.getLongestSubstring("Geeks"));
        Assert.assertEquals("aba", palindromicString.getLongestSubstring("forabafor"));
    }
}