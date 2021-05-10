package com.github.ajanthan.combinations;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    private Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void testPickKNumbers() {
        System.out.println(solution.pickKNumbers(new int[]{ 1, 2, 3 }, 2));
    }
}