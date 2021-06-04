package com.github.ajanthan.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * [5,1,4,null,null,3,6]
     *      5
     *     / \
     *    /   \
     *   1    4
     *       / \
     *      3   6
     *
     * @param vals
     * @return
     */
    public static TreeNode toTreeNode(Integer[] vals) {
        //5,1,4,null,null,3,6
        TreeNode root = new TreeNode(vals[0]);
        TreeNode leftNode = new TreeNode(vals[1]);
        TreeNode rightNode = new TreeNode(vals[2]);
        root.left = leftNode;
        root.right = rightNode;

        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(leftNode);
        que.add(rightNode);
        TreeNode node;
        int i = 3;
        while (!que.isEmpty() && i < vals.length) {
            node = que.pop();
            if (vals[i] != null) {
                leftNode = new TreeNode(vals[i]);
                node.left = leftNode;
                que.add(leftNode);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                rightNode = new TreeNode(vals[i]);
                node.right = rightNode;
                que.add(rightNode);
            }
            i++;
        }
        return root;
    }
}
