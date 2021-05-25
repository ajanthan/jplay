package com.github.ajanthan.jplay.algo.pattern.fibnumber;

import com.github.ajanthan.jplay.algo.pattern.fibnumber.HouseThief;
import junit.framework.TestCase;
import org.junit.Assert;

public class HouseThiefTest extends TestCase {
    private HouseThief houseThief;

    public void setUp() throws Exception {
        super.setUp();
        houseThief = new HouseThief();
    }

    public void testGetMaxValueCanBeStolen() {
        Assert.assertEquals(19, houseThief.getMaxValueCanBeStolen(new int[]{ 6, 7, 1, 3, 8, 2, 4 }));
        Assert.assertEquals(16, houseThief.getMaxValueCanBeStolen(new int[]{ 5, 3, 4, 11, 2 }));
        Assert.assertEquals(5, houseThief.getMaxValueCanBeStolen(new int[]{ 5 }));
        Assert.assertEquals(11, houseThief.getMaxValueCanBeStolen(new int[]{ 5, 11 }));
        Assert.assertEquals(15, houseThief.getMaxValueCanBeStolen(new int[]{ 5, 5, 5, 5, 5, 5 }));
    }
}