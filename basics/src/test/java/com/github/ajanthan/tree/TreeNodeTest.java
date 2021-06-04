package com.github.ajanthan.tree;

import junit.framework.TestCase;
import org.junit.Assert;

public class TreeNodeTest extends TestCase {

    public void testToTreeNode() {
        TreeNode root = TreeNode.toTreeNode(new Integer[]{ 5, 1, 4, null, null, 3, 6 });
        Assert.assertEquals(5, root.val);
        Assert.assertEquals(1, root.left.val);
        Assert.assertEquals(4, root.right.val);
        Assert.assertEquals(3, root.right.left.val);
        Assert.assertEquals(6, root.right.right.val);
    }
}