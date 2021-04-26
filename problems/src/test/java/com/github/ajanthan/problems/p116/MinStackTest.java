package com.github.ajanthan.problems.p116;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {
    @Test
    public void testMinStackV0() {
        MinStackV0 minStack = new MinStackV0();
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        Assert.assertEquals(-3, min);
        minStack.pop();
        min = minStack.top();
        Assert.assertEquals(0, min);
        min = minStack.getMin();
        Assert.assertEquals(-2, min);
    }

    @Test
    public void testMinStackV1() {
        MinStackV1 minStack = new MinStackV1();
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        Assert.assertEquals(-3, min);
        minStack.pop();
        min = minStack.top();
        Assert.assertEquals(0, min);
        min = minStack.getMin();
        Assert.assertEquals(-2, min);
    }

    @Test
    public void testMinStackV2() {
        MinStackV2 minStack = new MinStackV2();
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        Assert.assertEquals(-3, min);
        minStack.pop();
        min = minStack.top();
        Assert.assertEquals(0, min);
        min = minStack.getMin();
        Assert.assertEquals(-2, min);
    }
}