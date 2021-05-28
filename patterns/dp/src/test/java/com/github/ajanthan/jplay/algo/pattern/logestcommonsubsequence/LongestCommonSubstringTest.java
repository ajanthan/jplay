package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestCommonSubstringTest extends TestCase {
    private LongestCommonSubstring longestCommonSubstring;

    public void setUp() throws Exception {
        super.setUp();
        longestCommonSubstring = new LongestCommonSubstring();
    }

    public void testGetLengthV0() {
        Assert.assertEquals(5, longestCommonSubstring.getLengthV0("GeeksforGeeks", "GeeksQuiz"));
        Assert.assertEquals(4, longestCommonSubstring.getLengthV0("abcdxyz", "xyzabcd"));
        Assert.assertEquals(6, longestCommonSubstring.getLengthV0("zxabcdezy", "yzabcdezx"));

    }

    public void testGetLengthV1() {
        Assert.assertEquals(5, longestCommonSubstring.getLengthV1("GeeksforGeeks", "GeeksQuiz"));
        Assert.assertEquals(4, longestCommonSubstring.getLengthV1("abcdxyz", "xyzabcd"));
        Assert.assertEquals(6, longestCommonSubstring.getLengthV1("zxabcdezy", "yzabcdezx"));
    }
}