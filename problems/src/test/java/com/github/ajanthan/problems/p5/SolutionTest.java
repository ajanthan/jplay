package com.github.ajanthan.problems.p5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    private String[] ins;
    private String[][] ans;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
        ins = new String[]{ "babad",
                            "cbbd",
                            "a",
                            "ac",
                            "aaaba" };
        ans = new String[][]{ { "bab", "aba" }, { "bb" }, { "a" }, { "a" }, { "aba", "aaa" } };
    }

    @Test
    public void longestPalindromeV0() {
        String r;
        for (int i = 0; i < ins.length; i++) {
            r = solution.longestPalindromeV0(ins[i]);
            Assert.assertTrue(ans[i][0].equals(r) || (ans[i].length > 1 && ans[i][1].equals(r)));
        }
    }

    @Test
    public void longestPalindromeV1() {
        String r;
        for (int i = 0; i < ins.length; i++) {
            r = solution.longestPalindromeV1(ins[i]);
            Assert.assertTrue(ans[i][0].equals(r) || (ans[i].length > 1 && ans[i][1].equals(r)));
        }
    }

    @Test
    public void longestPalindromeV2() {
        String r;
        for (int i = 0; i < ins.length; i++) {
            r = solution.longestPalindromeV2(ins[i]);
            Assert.assertTrue(ans[i][0].equals(r) || (ans[i].length > 1 && ans[i][1].equals(r)));
        }
    }

//    @Test
//    public void longestPalindrome() {
//        String r;
//        for (int i = 0; i < ins.length; i++) {
//            r = solution.longestPalindrome(ins[i]);
//            Assert.assertTrue(ans[i][0].equals(r) || (ans[i].length > 1 && ans[i][1].equals(r)));
//        }
//    }
}