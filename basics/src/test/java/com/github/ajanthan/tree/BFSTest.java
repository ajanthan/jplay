package com.github.ajanthan.tree;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class BFSTest extends TestCase {

    public void testTraverse() {
        TreeNode root = TreeNode.toTreeNode(new Integer[]{ 5, 1, 4, null, null, 3, 6, 7, 8, 9, 10 });
        /*
         *      5
         *     / \
         *    /   \
         *   1    4
         *       / \
         *      /   \
         *     3     6
         *    / \   / \
         *   7  8  9   10
         */
        List<Integer> list = new BFS().traverse(root);
        Assert.assertArrayEquals(new Integer[]{ 5, 1, 4, 3, 6, 7, 8, 9, 10 }, list.toArray(new Integer[0]));
    }
}