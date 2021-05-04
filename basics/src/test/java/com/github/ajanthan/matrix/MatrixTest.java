package com.github.ajanthan.matrix;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class MatrixTest extends TestCase {
    private Matrix matrix;
    int[][] in1 = { { 1, 2 }, { 4, 3 } };
    int[][] in2 = { { 1, 2, 3, 4 } };
    int[][] in3 = { { 1 }, { 2 }, { 3 }, { 4 } };
    int[][] in4 = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };

    public void setUp() throws Exception {
        super.setUp();
        matrix = new Matrix();
    }

    public void testGetSpiralMatrix() {
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4 }, matrix.getSpiralMatrix(in1).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4 }, matrix.getSpiralMatrix(in2).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4 }, matrix.getSpiralMatrix(in3).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 }, matrix.getSpiralMatrix(in4).toArray(new Integer[0]));
    }

    public void testRotateMatrix() {
        matrix.rotateMatrix(in1);
        for (int[] a : in1) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        matrix.rotateMatrix(in4);
        for (int[] a : in4) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
}