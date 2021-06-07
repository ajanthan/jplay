package com.github.ajanthan.tree;

import junit.framework.TestCase;
import org.junit.Assert;

public class InOrderTest extends TestCase {

    public void testListToBST() {
        InOrder inOrder = new InOrder();
        TreeNode root = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 6, 7 });
        Assert.assertEquals(4, root.val);
        Assert.assertEquals(2, root.left.val);
        Assert.assertEquals(1, root.left.left.val);
        Assert.assertEquals(3, root.left.right.val);
        Assert.assertEquals(6, root.right.val);
        Assert.assertEquals(5, root.right.left.val);
        Assert.assertEquals(7, root.right.right.val);
    }
}