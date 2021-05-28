package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class StringTransformTest extends TestCase {
    private StringTransform stringTransform;

    public void setUp() throws Exception {
        super.setUp();
        stringTransform = new StringTransform();
    }

    public void testGetNumberOfDelIns() {
        StringTransform.Result result = stringTransform.getNumberOfDelIns("heap", "pea");
        Assert.assertEquals(2, result.deletions);
        Assert.assertEquals(1, result.insertions);

        result = stringTransform.getNumberOfDelIns("geeksforgeeks", "geeks");
        Assert.assertEquals(8, result.deletions);
        Assert.assertEquals(0, result.insertions);

        result = stringTransform.getNumberOfDelIns("geeks", "geeks");
        Assert.assertEquals(0, result.deletions);
        Assert.assertEquals(0, result.insertions);

        result = stringTransform.getNumberOfDelIns("", "geeks");
        Assert.assertEquals(0, result.deletions);
        Assert.assertEquals(5, result.insertions);

        result = stringTransform.getNumberOfDelIns("geeks", "");
        Assert.assertEquals(5, result.deletions);
        Assert.assertEquals(0, result.insertions);
    }
}