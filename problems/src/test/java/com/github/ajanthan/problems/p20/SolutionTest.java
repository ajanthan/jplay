package com.github.ajanthan.problems.p20;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    private String[] ins;
    private boolean[] ans;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
        ins = new String[]{ "()",
                            "()[]{}",
                            "(]",
                            "([)]",
                            "{[]}",
                            "(",
                            "([)",
                            "{]}",
                            "{}[",
                            "{}(" };
        ans = new boolean[]{ true, true, false, false, true, false, false, false, false, false };
    }

    @Test
    public void isValid() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.isValid(ins[i]));
        }
    }

    @Test
    public void isValidV1() {
        for (int i = 0; i < ins.length; i++) {
            Assert.assertEquals(ans[i], solution.isValidV1(ins[i]));
        }
    }
}