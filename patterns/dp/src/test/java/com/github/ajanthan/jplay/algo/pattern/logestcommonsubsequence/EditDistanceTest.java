package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class EditDistanceTest extends TestCase {
    private EditDistance editDistance;

    public void setUp() throws Exception {
        super.setUp();
        editDistance = new EditDistance();
    }

    public void testGetMinOpToChangeV1() {
        Assert.assertEquals(1, editDistance.getMinOpToChangeV1("geek", "gesek"));
        Assert.assertEquals(1, editDistance.getMinOpToChangeV1("cat", "cut"));
        Assert.assertEquals(3, editDistance.getMinOpToChangeV1("sunday", "saturday"));
    }
    public void testGetMinOpToChangeV2() {
        Assert.assertEquals(1, editDistance.getMinOpToChangeV2("geek", "gesek"));
        Assert.assertEquals(1, editDistance.getMinOpToChangeV2("cat", "cut"));
        Assert.assertEquals(3, editDistance.getMinOpToChangeV2("sunday", "saturday"));
    }
}