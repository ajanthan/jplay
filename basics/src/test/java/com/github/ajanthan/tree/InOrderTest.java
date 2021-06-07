package com.github.ajanthan.tree;

import junit.framework.TestCase;
import org.junit.Assert;

public class InOrderTest extends TestCase {

    public void testListToBST() {
        InOrder inOrder = new InOrder();
        TreeNode root = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 6, 7 });
        inOrder.printTree(root);
        Assert.assertEquals(4, root.val);
        Assert.assertEquals(2, root.left.val);
        Assert.assertEquals(1, root.left.left.val);
        Assert.assertEquals(3, root.left.right.val);
        Assert.assertEquals(6, root.right.val);
        Assert.assertEquals(5, root.right.left.val);
        Assert.assertEquals(7, root.right.right.val);
    }

    public void testIsBinaryTree() {
        InOrder inOrder = new InOrder();
        TreeNode root0 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 6, 7 });
        TreeNode root1 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 6, 5, 7 });
        TreeNode root2 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 7, 7 });
        TreeNode root3 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 7, 6 });

        Assert.assertTrue(inOrder.isBinarySearchTree(root0));
        Assert.assertFalse(inOrder.isBinarySearchTree(root1));
        Assert.assertFalse(inOrder.isBinarySearchTree(root2));
        Assert.assertFalse(inOrder.isBinarySearchTree(root3));
    }

    public void testIsBinarySearchTreeRecursive() {
        InOrder inOrder = new InOrder();
        TreeNode root0 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 6, 7 });
        TreeNode root1 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 6, 5, 7 });
        TreeNode root2 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 7, 7 });
        TreeNode root3 = inOrder.listToBST(new Integer[]{ 1, 2, 3, 4, 5, 7, 6 });

        Assert.assertTrue(inOrder.isBinarySearchTreeRecursive(root0));
        Assert.assertFalse(inOrder.isBinarySearchTreeRecursive(root1));
        Assert.assertFalse(inOrder.isBinarySearchTreeRecursive(root2));
        Assert.assertFalse(inOrder.isBinarySearchTreeRecursive(root3));
    }
}