package com.github.ajanthan.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BFS {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        TreeNode node;
        while (!que.isEmpty()) {
            node = que.pop();
            list.add(node.val);
            if (node.left != null) {
                que.add(node.left);
            }
            if (node.right != null) {
                que.add(node.right);
            }
        }
        return list;
    }
}
