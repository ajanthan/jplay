package com.github.ajanthan.jplay.algo.pattern.unboundedknapsack;

import com.github.ajanthan.jplay.algo.pattern.unboundedknapsack.UnboundedKnapsack;
import junit.framework.TestCase;
import org.junit.Assert;

public class UnboundedKnapsackTest extends TestCase {
    private UnboundedKnapsack unboundedKnapsack;

    public void setUp() throws Exception {
        super.setUp();
        unboundedKnapsack = new UnboundedKnapsack();
    }

    public void testGetMaxValue() {
        Assert.assertEquals(100, unboundedKnapsack.getMaxValueV0(new int[]{ 1, 30 }, new int[]{ 1, 50 }, 100));
        Assert.assertEquals(110, unboundedKnapsack.getMaxValueV0(new int[]{ 10, 40, 50, 70 }, new int[]{ 1, 3, 4, 5 }, 8));
    }

    public void testGetMaxValueV1() {
        Assert.assertEquals(100, unboundedKnapsack.getMaxValueV1(new int[]{ 1, 30 }, new int[]{ 1, 50 }, 100));
        Assert.assertEquals(110, unboundedKnapsack.getMaxValueV1(new int[]{ 10, 40, 50, 70 }, new int[]{ 1, 3, 4, 5 }, 8));
    }

    public void testGetMaxValueV2() {
        Assert.assertEquals(100, unboundedKnapsack.getMaxValueV2(new int[]{ 1, 30 }, new int[]{ 1, 50 }, 100));
        Assert.assertEquals(110, unboundedKnapsack.getMaxValueV2(new int[]{ 10, 40, 50, 70 }, new int[]{ 1, 3, 4, 5 }, 8));
    }
}