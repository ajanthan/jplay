package com.github.ajanthan.tree;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class DFSTest extends TestCase {

    public void testTraverse() {
        TreeNode root = TreeNode.toTreeNode(new Integer[]{ 5, 1, 4, null, null, 3, 6 });
        /*
         *      5
         *     / \
         *    /   \
         *   1    4
         *       / \
         *      3   6
         */
        List<Integer> list = new DFS().traverse(root);
        Assert.assertArrayEquals(new Integer[]{ 1, 5, 3, 4, 6 }, list.toArray(new Integer[0]));
    }

    public void testTraverseIterator() {
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
        List<Integer> list = new DFS().traverseIterator(root);
        Assert.assertArrayEquals(new Integer[]{ 1, 5, 7, 3, 8, 4, 9, 6, 10 }, list.toArray(new Integer[0]));
    }
}