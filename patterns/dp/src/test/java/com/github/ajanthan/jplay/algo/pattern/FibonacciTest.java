package com.github.ajanthan.jplay.algo.pattern;

import junit.framework.TestCase;
import org.junit.Assert;

public class FibonacciTest extends TestCase {
    private Fibonacci fibonacci;

    public void setUp() throws Exception {
        super.setUp();
        fibonacci = new Fibonacci();
    }

    public void testCalculateRecursively() {
        Assert.assertEquals(55, fibonacci.calculateRecursively(10));
        System.out.println(Fibonacci.callCount);
        Assert.assertEquals(55, fibonacci.calculateIteratively(10));
        Fibonacci.callCount = 0;
        Assert.assertEquals(55, fibonacci.calculateRecursively(10, new int[10]));
        System.out.println(Fibonacci.callCount);
    }
}