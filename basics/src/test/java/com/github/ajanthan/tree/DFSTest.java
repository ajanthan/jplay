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
        List<Integer> list1 = new DFS().traverse(root, DFS.Method.RECURSIVE, DFS.Order.IN_ORDER);
        Assert.assertArrayEquals(new Integer[]{ 1, 5, 3, 4, 6 }, list1.toArray(new Integer[0]));

        List<Integer> list2 = new DFS().traverse(root, DFS.Method.RECURSIVE, DFS.Order.PRE_ORDER);
        Assert.assertArrayEquals(new Integer[]{ 5, 1, 4, 3, 6 }, list2.toArray(new Integer[0]));

        List<Integer> list3 = new DFS().traverse(root, DFS.Method.RECURSIVE, DFS.Order.POST_ORDER);
        Assert.assertArrayEquals(new Integer[]{ 1, 3, 6, 4, 5 }, list3.toArray(new Integer[0]));
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
        List<Integer> list1 = new DFS().traverse(root, DFS.Method.ITERATIVE, DFS.Order.IN_ORDER);
        Assert.assertArrayEquals(new Integer[]{ 1, 5, 7, 3, 8, 4, 9, 6, 10 }, list1.toArray(new Integer[0]));

        List<Integer> list2 = new DFS().traverse(root, DFS.Method.ITERATIVE, DFS.Order.PRE_ORDER);
        Assert.assertArrayEquals(new Integer[]{ 5, 1, 4, 3, 7, 8, 6, 9, 10 }, list2.toArray(new Integer[0]));

        List<Integer> list3 = new DFS().traverse(root, DFS.Method.ITERATIVE, DFS.Order.POST_ORDER);
        Assert.assertArrayEquals(new Integer[]{ 1, 7, 8, 3, 9, 10, 6, 4, 5 }, list3.toArray(new Integer[0]));
    }
}