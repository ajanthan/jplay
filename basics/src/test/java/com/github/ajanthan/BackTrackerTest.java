package com.github.ajanthan;

import junit.framework.TestCase;
import org.junit.Assert;

public class BackTrackerTest extends TestCase {
    int[][] grid1 = { { 0, 1, 1 },
                      { 1, 1, 1 },
                      { 1, 1, 0 } };

    int[][] grid2 = { { 0, 0 },
                      { 0, 0 } };

    int[][] grid3 = { { 0, 0, 0 },
                      { 1, 1, 0 },
                      { 1, 1, 0 } };

    int[][] grid4 = { { 0, 0, 1, 1 },
                      { 1, 0, 1, 1 },
                      { 1, 0, 0, 0 },
                      { 1, 1, 1, 0 } };

    int[][] grid5 = { { 0, 0, 0, 0, 0 },
                      { 0, 1, 1, 1, 0 },
                      { 0, 1, 0, 1, 0 },
                      { 0, 1, 1, 1, 0 },
                      { 0, 0, 0, 0, 0 } };

    int[][] grid6 = { { 0, 0, 0, 0, 0 },
                      { 0, 1, 1, 1, 0 },
                      { 0, 1, 0, 1, 0 },
                      { 0, 1, 0, 1, 0 },
                      { 0, 0, 0, 0, 0 } };

    BackTracker backTracker;

    public void setUp() throws Exception {
        super.setUp();
        backTracker = new BackTracker();
    }

    public void testIsReachable() {
        Assert.assertFalse(backTracker.isReachable(grid1, 0, 0, 2, 2));
        Assert.assertTrue(backTracker.isReachable(grid2, 0, 0, 1, 1));
        Assert.assertTrue(backTracker.isReachable(grid3, 0, 0, 2, 2));
        Assert.assertTrue(backTracker.isReachable(grid4, 0, 0, 3, 3));
        Assert.assertFalse(backTracker.isReachable(grid5, 0, 0, 2, 2));
        Assert.assertTrue(backTracker.isReachable(grid6, 0, 0, 2, 2));
    }
}