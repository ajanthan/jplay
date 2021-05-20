package com.github.ajanthan.jplay.algo.pattern.zerooneknapsack;

import com.github.ajanthan.jplay.algo.pattern.unboundedknapsack.RodCutting;
import junit.framework.TestCase;
import org.junit.Assert;

public class RodCuttingTest extends TestCase {
    private RodCutting rodCutting;

    public void setUp() throws Exception {
        super.setUp();
        rodCutting = new RodCutting();
    }

    public void testMaxTotalSale() {
        Assert.assertEquals(22, rodCutting.maxTotalSaleV1(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, new int[]{ 1, 5, 8, 9, 10, 17, 17, 20 }, 8));
        Assert.assertEquals(24, rodCutting.maxTotalSaleV1(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, new int[]{ 3, 5, 8, 9, 10, 17, 17, 20 }, 8));
    }
}