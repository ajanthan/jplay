package com.github.ajanthan.jplay.algo.pattern.fibnumber;

import junit.framework.TestCase;
import org.junit.Assert;

public class MinimumJumpTest extends TestCase {
    private MinimumJump minimumJump;

    public void setUp() throws Exception {
        super.setUp();
        minimumJump = new MinimumJump();
    }

    public void testGetMinJumpsV0() {
        Assert.assertEquals(3, minimumJump.getMinJumpsV0(new int[]{ 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }));
        Assert.assertEquals(-1, minimumJump.getMinJumpsV0(new int[]{ 1, 2, 1, 1, 0, 2, 6, 7, 6, 8, 9 }));
        Assert.assertEquals(10, minimumJump.getMinJumpsV0(new int[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
    }

    public void testGetMinJumpsV1() {
        Assert.assertEquals(3, minimumJump.getMinJumpsV1(new int[]{ 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }));
        Assert.assertEquals(-1, minimumJump.getMinJumpsV1(new int[]{ 1, 2, 1, 1, 0, 2, 6, 7, 6, 8, 9 }));
        Assert.assertEquals(10, minimumJump.getMinJumpsV1(new int[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
    }
}