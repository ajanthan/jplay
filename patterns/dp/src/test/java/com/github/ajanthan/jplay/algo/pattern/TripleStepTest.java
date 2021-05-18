package com.github.ajanthan.jplay.algo.pattern;

import junit.framework.TestCase;

public class TripleStepTest extends TestCase {
    TripleStep tripleStep;

    public void setUp() throws Exception {
        super.setUp();
        tripleStep = new TripleStep();
    }

    public void testGetPossibleWays() {
        System.out.println(tripleStep.getPossibleWaysV1(5));
    }

    public void testGetPossibleWaysV2() {
        System.out.println(tripleStep.getPossibleWaysV2(5));
    }
}