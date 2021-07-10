package com.github.ajanthan.graphs;

import junit.framework.TestCase;
import org.junit.Assert;

public class MatrixTest extends TestCase {

    public void testFindNearestZero() {
        int[][] in1 = new int[][]{ { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] res1 = new int[][]{ { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] in2 = new int[][]{ { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] res2 = new int[][]{ { 0, 0, 0 }, { 0, 1, 0 }, { 1, 2, 1 } };

        Matrix matrix = new Matrix();
        Assert.assertArrayEquals(res1, matrix.findNearestZero(in1));
        Assert.assertArrayEquals(res2, matrix.findNearestZero(in2));
    }
}