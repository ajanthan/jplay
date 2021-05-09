package com.github.ajanthan.permutations;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    private Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void testGetPermutations() {
        System.out.println((solution.getArrayPermutations(new int[]{ 1, 2, 3 })));
    }

    public void testGetStringPermutations() {
        System.out.println(solution.getStringPermutations("cat"));
    }
}