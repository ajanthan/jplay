package com.github.ajanthan.subset;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    private Solution solution;

    public void setUp() throws Exception {
        super.setUp();
        solution = new Solution();
    }

    public void testGetAllSubsets() {
        System.out.println(solution.getAllSubsets(new int[]{ 1, 2, 3 }));
    }

    public void testGetAllSubsetsBT() {
        System.out.println(solution.getAllSubsetsBT(new int[]{ 1, 2, 3 }));
    }
}