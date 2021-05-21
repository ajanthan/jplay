package com.github.ajanthan.jplay.algo.pattern.fibnumber;

import junit.framework.TestCase;
import org.junit.Assert;

public class DivisorsTest extends TestCase {

    public void testTotalDivisorsV1() {
        Divisors divisors = new Divisors();
        Assert.assertEquals(3, divisors.totalDivisorsV1(25));
        Assert.assertEquals(8, divisors.totalDivisorsV1(24));
    }

    public void testTotalDivisorsV2() {
        Divisors divisors = new Divisors();
        Assert.assertEquals(3, divisors.totalDivisorsV2(25));
        Assert.assertEquals(8, divisors.totalDivisorsV2(24));
    }
}