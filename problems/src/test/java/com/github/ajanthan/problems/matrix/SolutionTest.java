package com.github.ajanthan.problems.matrix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void luckyNumbersTest1() {
        int[][] matrix = new int[][]{
            { 1, 10, 4, 2 },
            { 9, 3, 8, 7 },
            { 15, 16, 17, 12 }
        };
        List<Integer> result = solution.luckyNumbers(matrix);
        Assert.assertArrayEquals(new Integer[]{ 12 }, result.toArray(new Integer[0]));
    }

    @Test
    public void luckyNumbersTest2() {
        int[][] matrix = new int[][]{
            { 3, 7, 8 },
            { 9, 11, 13 },
            { 15, 16, 17 }
        };
        List<Integer> result = solution.luckyNumbers(matrix);
        Assert.assertArrayEquals(new Integer[]{ 15 }, result.toArray(new Integer[0]));
    }

    @Test
    public void luckyNumbersTest3() {
        int[][] matrix = new int[][]{
            { 7, 8 },
            { 1, 2 }
        };
        List<Integer> result = solution.luckyNumbers(matrix);
        Assert.assertArrayEquals(new Integer[]{ 7 }, result.toArray(new Integer[0]));
    }
}