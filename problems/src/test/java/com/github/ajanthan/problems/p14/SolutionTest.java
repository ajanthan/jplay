package com.github.ajanthan.problems.p14;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    private String[][] ins;
    private String[] ans;

    @Before
    public void setUp() throws Exception {
        this.solution = new Solution();
        ins = new String[][]{ { "flower", "flow", "flight" },
                              { "dog", "racecar", "car" },
                              { "flower", "fl", "flight" },
                              { "flower", "", "flight" },
                              { "flower", "flow", "fl" }
        };
        ans = new String[]{ "fl", "", "fl", "", "fl" };
    }

    @Test
    public void longestCommonPrefixV0() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.longestCommonPrefixV0(ins[i]));
        }
    }

    @Test
    public void longestCommonPrefixV1() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.longestCommonPrefixV1(ins[i]));
        }
    }
}