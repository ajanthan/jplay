package com.github.ajanthan.jplay.algo.pattern;

import junit.framework.TestCase;
import org.junit.Assert;

public class MatrixChainMultiplicationTest extends TestCase {
    private MatrixChainMultiplication matrixChainMultiplication;

    public void setUp() throws Exception {
        super.setUp();
        matrixChainMultiplication = new MatrixChainMultiplication();
    }

    public void testMinOperationMultiplicationV0() {
        Assert.assertEquals(26000, matrixChainMultiplication.minOperationMultiplicationV0(new int[]{ 40, 20, 30, 10, 30 }));
        Assert.assertEquals(30000, matrixChainMultiplication.minOperationMultiplicationV0(new int[]{ 10, 20, 30, 40, 30 }));
        Assert.assertEquals(6000, matrixChainMultiplication.minOperationMultiplicationV0(new int[]{ 10, 20, 30 }));
    }

    public void testMinOperationMultiplicationV1() {
        Assert.assertEquals(26000, matrixChainMultiplication.minOperationMultiplicationV1(new int[]{ 40, 20, 30, 10, 30 }));
        Assert.assertEquals(30000, matrixChainMultiplication.minOperationMultiplicationV1(new int[]{ 10, 20, 30, 40, 30 }));
        Assert.assertEquals(6000, matrixChainMultiplication.minOperationMultiplicationV1(new int[]{ 10, 20, 30 }));
    }
}