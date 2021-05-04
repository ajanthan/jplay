package com.github.ajanthan.matrix;

import junit.framework.TestCase;
import org.junit.Assert;

public class SpiralMatrixTest extends TestCase {
    private SpiralMatrix spiralMatrix;

    public void setUp() throws Exception {
        super.setUp();
        spiralMatrix = new SpiralMatrix();
    }

    public void testGetSpiralMatrix() {
        int[][] in1 = { { 1, 2 }, { 4, 3 } };
        int[][] in2 = { { 1, 2, 3, 4 } };
        int[][] in3 = { { 1 }, { 2 }, { 3 }, { 4 } };
        int[][] in4 = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4 }, spiralMatrix.getSpiralMatrix(in1).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4 }, spiralMatrix.getSpiralMatrix(in2).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4 }, spiralMatrix.getSpiralMatrix(in3).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 }, spiralMatrix.getSpiralMatrix(in4).toArray(new Integer[0]));
    }
}