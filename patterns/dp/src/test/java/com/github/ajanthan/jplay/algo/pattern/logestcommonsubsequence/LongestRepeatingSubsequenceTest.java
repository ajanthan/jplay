package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestRepeatingSubsequenceTest extends TestCase {

//    public void testGetMaxLengthV0() {
//        Assert.assertEquals(3, LongestRepeatingSubsequence.getMaxLengthV0("AABEBCDD"));
//        Assert.assertEquals(0, LongestRepeatingSubsequence.getMaxLengthV0("abc"));
//        Assert.assertEquals(1, LongestRepeatingSubsequence.getMaxLengthV0("aac"));
//        Assert.assertEquals(2, LongestRepeatingSubsequence.getMaxLengthV0("aabb"));
//        Assert.assertEquals(1, LongestRepeatingSubsequence.getMaxLengthV0("axxxy"));
//        Assert.assertEquals(2, LongestRepeatingSubsequence.getMaxLengthV0("aaxxxya"));
//    }

    public void testGetMaxLengthV1() {
        Assert.assertEquals(3, LongestRepeatingSubsequence.getMaxLengthV1("AABEBCDD"));
        Assert.assertEquals(0, LongestRepeatingSubsequence.getMaxLengthV1("abc"));
        Assert.assertEquals(1, LongestRepeatingSubsequence.getMaxLengthV1("aac"));
        Assert.assertEquals(2, LongestRepeatingSubsequence.getMaxLengthV1("aabb"));
        Assert.assertEquals(2, LongestRepeatingSubsequence.getMaxLengthV1("axxxy"));
        Assert.assertEquals(3, LongestRepeatingSubsequence.getMaxLengthV1("aaxxxya"));
    }
}