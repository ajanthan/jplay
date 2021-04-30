package com.github.ajanthan.problems.p3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    private String[] ins;
    private int[] ans;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
        ins = new String[]{ "abcabcbb",
                            "bbbbb",
                            "pwwkew",
                            "",
                            "ab",
                            "a",
                            "aabca" };
        ans = new int[]{ 3, 1, 3, 0, 2, 1, 3 };
    }

    @Test
    public void lengthOfLongestSubstringV0() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.lengthOfLongestSubstringV0(ins[i]));
        }
    }

    @Test
    public void lengthOfLongestSubstringV1() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.lengthOfLongestSubstringV1(ins[i]));
        }
    }

    @Test
    public void lengthOfLongestSubstringV2() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.lengthOfLongestSubstringV2(ins[i]));
        }
    }
}