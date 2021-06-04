package com.github.ajanthan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverseRecursively(root, list);
        return list;
    }

    private void traverseRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverseRecursively(root.left, list);
        list.add(root.val);
        traverseRecursively(root.right, list);
    }

    public List<Integer> traverseIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root.left;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}
